package org.amazon.example;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin/dashboard")
    public String adminDashboard() {
        return "Welcome to the admin dashboard!";
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/user/profile")
    public String userProfile() {
        return "Welcome to your profile!";
    }
}