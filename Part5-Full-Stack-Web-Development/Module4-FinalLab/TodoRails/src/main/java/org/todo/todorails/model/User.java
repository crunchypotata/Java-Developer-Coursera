package org.todo.todorails.model;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Entity
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;


    @Column(nullable = false, unique = false)
    private String email;

    private String highestQualification;

    @ElementCollection
    private List<String> hobbies;

    private Boolean termsAccepted = false;


    // Overriding methods of UserDetails interface

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Assuming a simple user role future provision
        // for more complex scenarios, you may want a Role entity
        // currently returns an empty list
        // return authorities if roles are added
        return Collections.emptyList();
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        // Fixed values, you can have fields to represent state
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // Fixed values, you can have fields to represent state
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // Fixed values, you can have fields to represent state
        return true;
    }

    @Override
    public boolean isEnabled() {
        // Fixed values, you can have fields to represent state
        return true;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHighestQualification() {
        return highestQualification;
    }

    public void setHighestQualification(String highestQualification) {
        this.highestQualification = highestQualification;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public Boolean getTermsAccepted() {
        return termsAccepted;
    }

    public void setTermsAccepted(Boolean termsAccepted) {
        this.termsAccepted = termsAccepted;
    }
}
