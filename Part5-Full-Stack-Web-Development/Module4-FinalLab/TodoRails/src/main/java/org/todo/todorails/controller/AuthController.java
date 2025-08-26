package org.todo.todorails.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.todo.todorails.model.User;
import org.todo.todorails.service.UserService;

@Controller
public class AuthController {

    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    // Handler for registration page
    @GetMapping("/register")
    public String showRegistrationPage(Model model) {
        // Add empty User
        model.addAttribute("user", new User());

        // Returns the register.html page
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user, Model model,
                               RedirectAttributes redirectAttributes) {

        try {
            // Register the user in the service
            User userReturned = userService.registerUser(user);

            System.out.println("All success ");
            // If successful, add a success message and redirect to login
            redirectAttributes.addFlashAttribute("successMessage", "You have been registered. Please login.");

            // Redirect to login
            return "redirect:/login";

        } catch(Exception e) {

            // if it is due to username already exists
            if(e.getMessage().equalsIgnoreCase("Username already exists")) {
                redirectAttributes.addFlashAttribute("errorMessage", "Registration unsuccessful due to existing username. Please try again.");
            } else {
                redirectAttributes.addFlashAttribute("errorMessage", "Registration unsuccessful. Please try again.");
            }

            model.addAttribute("user", user);

            // Redirect to register
            return "redirect:/register";
        }
    }
}
