package org.todo.todorails.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.todo.todorails.model.User;
import org.todo.todorails.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public User registerUser(User user) throws Exception {

        // Check if username already exists
        /** TODO 8 (b): uncomment the method below checking for testing if a username exists **/

        if (userRepository.existsByUsername(user.getUsername())) {
            throw new Exception("Username already exists");
        }


        // Encrypt the password
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Set terms accepted to true
        user.setTermsAccepted(true);

        // Save the new user
        return userRepository.save(user);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByUsername(username);

        // Check if user with username exists
        if (user == null) {

            // If username does not exist then check if email is passed
            user = findByEmail(username);

            // Check if user with email exists
            if(user == null) {
                throw new UsernameNotFoundException("User not found with username: " + username);
            }
        }
        return user;
    }
}
