package org.todo.todorails.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.todo.todorails.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Method to find a user by their username
    User findByUsername(String username);

    // Method to find a user by their email
    User findByEmail(String email);

    /**
     * TODO 8 (a): define a query to find check if a user exists by username
     **/
    // Method to check a user exists by their username. Should be named existsByUsername().

    boolean existsByUsername(String username);

    // Method to check a user exists by their email
    boolean existsByEmail(String email);

}
