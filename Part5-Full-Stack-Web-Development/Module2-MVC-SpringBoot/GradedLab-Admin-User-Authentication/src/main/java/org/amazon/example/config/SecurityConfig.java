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

@Configuration
public class SecurityConfig {

    private final UserService userService;

    public SecurityConfig(UserService userService) {
        this.userService = userService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests()
                .requestMatchers("/register", "/login").permitAll()  // Allow public access to these pages
                //TODO 3: Only ADMIN can access /admin/* url
                .requestMatchers("/admin/**").hasRole("ADMIN")           // Только ADMIN
                //TODO 4: Only USER can access /user/* url
                .requestMatchers("/user/**").hasRole("USER")
                .anyRequest().authenticated()                         // Secure all other pages
                .and()
                .formLogin()                                             // Enable form login
                .loginPage("/login")
                .defaultSuccessUrl("/welcome", true)                 // Redirect after successful login
                .and()
                .logout().permitAll();

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
