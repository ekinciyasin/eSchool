package com.ekinci.eSchool.dto;

import com.ekinci.eSchool.model.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@NoArgsConstructor
public abstract class UserDTO{
    private String username;
    private String lastName;
    private String firstName;

    private Set<Role> authorities;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Set<Role> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Role> authorities) {
        this.authorities = authorities;
    }

    public UserDTO(String username, String lastName, String firstName
                  // Set<Role> authorities
    ) {
        this.username = username;
        this.lastName = lastName;
        this.firstName = firstName;
     //   this.authorities = authorities;
    }

}
