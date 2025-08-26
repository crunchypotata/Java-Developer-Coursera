package org.todo.todorails.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PageController {

    // Handler for home (index) page
    @GetMapping("/")
    public String showIndexPage() {
        return "index";  // Returns the index.html page
    }

    // Handler for login page
    @GetMapping("/login")
    public String showLoginPage(RedirectAttributes redirectAttributes) {
        return "login";  // Returns the login.html page
    }

    // Handler for terms and conditions page
    @GetMapping("/terms")
    public String showTermsPage() {
        return "terms";
    }

}
