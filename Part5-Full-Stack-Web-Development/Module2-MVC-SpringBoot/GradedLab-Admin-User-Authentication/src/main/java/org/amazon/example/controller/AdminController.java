package org.amazon.example.controller;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/admin/dashboard")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminDashboard() {
        return "admin-dashboard";
    }

    @GetMapping("/user/profile")
    @PreAuthorize("hasRole('USER')")
    public String userProfile() {
        return "user-profile";
    }

}
