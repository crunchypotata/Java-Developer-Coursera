package org.amazon.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Welcome to the public page!";
    }

    @GetMapping("/secure")
    public String secure() {
        return "You are viewing a secure page!";
    }
}
