package org.amazon.example;

import org.springframework.stereotype.Service;

@Service
public class WelcomeService {

    public String getWelcomeMessage() {
        return "Welcome to the Spring Boot REST API!";
    }
}
