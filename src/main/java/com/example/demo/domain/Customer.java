package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Collections;

@Entity
@Getter
@Setter
public class Customer implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long customerId;
    private String customerName;
    private String customerEmail;
    private String password;

    // Assuming you have a Workout entity related to Customer
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private Collection<Workout> workouts;

    // Implement a boolean field to represent whether the user is enabled or not
    private boolean enabled = true;

    // Additional fields for account status
    private boolean accountNonExpired = true;
    private boolean accountNonLocked = true;
    private boolean credentialsNonExpired = true;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Return an empty list of authorities (roles/privileges)
        return Collections.emptyList();
    }

    @Override
    public String getUsername() {
        // Use customerEmail as the username
        return customerEmail;
    }

    @Override
    public boolean isAccountNonExpired() {
        // Return the accountNonExpired field
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        // Return the accountNonLocked field
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // Return the credentialsNonExpired field
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        // Return the enabled field
        return enabled;
    }

    // Implement setters for the boolean fields if necessary

    // Other getters, setters, and business logic
}
