package org.todo.todorails.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public ModelAndView handleError(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated() ) {
            redirectAttributes.addFlashAttribute("errorMessage","Redirected to Dashboard due to issue!");
            return new ModelAndView("redirect:/dashboard");
        }
        return new ModelAndView("redirect:/login");
    }

    // Override the default error path (not strictly required, but good practice)
    public String getErrorPath() {
        return "/error";
    }
}
