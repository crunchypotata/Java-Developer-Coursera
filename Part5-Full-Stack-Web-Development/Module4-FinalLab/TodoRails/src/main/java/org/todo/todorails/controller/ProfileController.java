package org.todo.todorails.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.todo.todorails.model.User;
import org.todo.todorails.service.UserService;

@Controller
public class ProfileController {


    @Autowired
    // The service to handle user data
    private UserService userService;

    @Autowired
    // Encoder to check and encode passwords
    private PasswordEncoder passwordEncoder;


    // Endpoint to return password page
    @GetMapping("/changepasswd")
    public String getChangePassword() {
        return "changepasswd";
    }

    // Endpoint to handle password change
    @PostMapping("/changepasswd")
    public String changePassword(String currentPassword, String newPassword, RedirectAttributes redirectAttributes) {

        // Get the current logged-in user
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Retrieve the username from the session
        String username = authentication.getName();

        // Fetch the user based on the username
        User user = userService.findByUsername(username);

        // Check if the provided current password matches the stored password
        /** TODO 23 (a) : The if statement
         *               should execute if the user is null or the
         *               existing password and currentPassword passed do not match.
         *               Use the "matches" method of the password encoder
         *           the first parameter or this method is the password in
         *           plain string, i.e., currentPassword and the 2nd parameter
         *           is the encoded password, which can be retrieved from the
         *           getPassword method of the user object to check that the
         *           passwords are same.
         **/
        if (user == null ) {

            // If passwords don't match, add a flash message and redirect to the dashboard
            redirectAttributes.addFlashAttribute("errorMessage", "Password not updated");

            // Redirect to the dashboard
            return "redirect:/dashboard";

        }


        // Encode the new password
        /** TODO 23 (b) :  use the "encode" method to encode the new password passed in "newPassword" **/
        String encodedPassword = newPassword;

        // Update the password with the new password
        /** TODO 23 (c) :  update the password in the "user" object using "setPassword" of the User class**/


        // Save the user with the updated password
        /** TODO 23 (d) :  update the "user" object by using the "save" method of the "UserService" **/


        // Add a success flash message and redirect to the dashboard
        redirectAttributes.addFlashAttribute("successMessage", "Password updated");
        return "redirect:/dashboard";
    }
}
