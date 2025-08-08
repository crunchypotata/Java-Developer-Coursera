package org.amazon.example.service;


import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.amazon.example.model.User;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    private final Map<String, User> users = new HashMap<>();
    private final PasswordEncoder passwordEncoder;

    public UserService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;

        // Adding a default admin user
        User admin = new User();
        admin.setUsername("admin");
        admin.setPassword(passwordEncoder.encode("admin123"));
        admin.setRole("ADMIN");  // Assigning ADMIN role
        users.put(admin.getUsername(), admin);

        // Adding a default regular user
        User user = new User();
        user.setUsername("user");
        user.setPassword(passwordEncoder.encode("user123"));
        user.setRole("USER");  // Assigning USER role
        users.put(user.getUsername(), user);
    }

    public void registerUser(User user) {
        // Encode the password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        users.put(user.getUsername(), user);  // Store the user in the map
    }

    public User findByUsername(String username) {
        return users.get(username);
    }
}
