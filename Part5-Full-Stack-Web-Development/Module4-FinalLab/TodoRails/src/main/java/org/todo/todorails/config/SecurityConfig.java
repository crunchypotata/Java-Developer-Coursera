package org.todo.todorails.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.todo.todorails.service.UserService;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final UserService userService;

    // Constructor to inject UserService, which we’ll use for loading user details
    public SecurityConfig(UserService userService) {
        this.userService = userService;
    }

    // Create and configure a SecurityFilterChain bean
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeRequests(authorize -> authorize
                        /** TODO 1:  allow access to static resource "/css/**" and
                         *           "/register" without logging in
                         */
                        .requestMatchers("/css/**", "/register").permitAll()
                        // allow access to static resources
                        .requestMatchers("/js/**", "/images/**").permitAll()
                        // allow access to register, login, terms and index without logging in
                        .requestMatchers("/","/login","/terms", "/custom-error").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/dashboard")
                        // Redirects the user to the login page
                        .failureUrl("/login?error")
                        .permitAll()
                )
                .logout(logout -> logout.permitAll());

        return http.build();
    }


    // Create a PasswordEncoder bean to encode passwords
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Configure the AuthenticationManager to use our UserService and password encoder
    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder auth = http.getSharedObject(AuthenticationManagerBuilder.class);
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
        return auth.build();
    }
}
