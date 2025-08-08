package org.amazon.example.config;

import org.amazon.example.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.Customizer;

@Configuration
public class SecurityConfig {

    private final UserService userService;

    public SecurityConfig(UserService userService) {
        this.userService = userService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.ignoringRequestMatchers("/products/**"))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/register", "/login").permitAll()   // публичные страницы
                        .requestMatchers("/admin/**").hasRole("ADMIN")        // только ADMIN
                        .requestMatchers("/user/**").hasRole("USER")          // только USER
                        .requestMatchers("/products/**").authenticated()      // продукты — любой вошедший
                        .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults())                     // Basic Auth для API
                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/welcome", true)
                )
                .logout(logout -> logout.permitAll());

        return http.build();
    }


    @Bean
    public UserDetailsService userDetailsService() {
        return username -> {
            org.amazon.example.model.User user = userService.findByUsername(username);
            if (user == null) {
                throw new UsernameNotFoundException("User not found");
            }
            UserBuilder builder = User.withUsername(user.getUsername());
            builder.password(user.getPassword());  // Password is already encoded
            if(user.getRole() != null) {
                builder.roles(user.getRole());
            }
            return builder.build();
        };
    }
}
