package com.ekinci.eSchool.dto;

import com.ekinci.eSchool.model.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.util.Set;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserDto {
    private String username;
    private String lastName;
    private String firstName;
    private String password;

    private Set<String> authorities;
    private String token;



    public UserDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserDto(String username, String lastName, String firstName, String password) {
        this.username = username;
        this.lastName = lastName;
        this.firstName = firstName;
        this.password = password;
    }

    public UserDto(String username, String lastName, String firstName) {
        this.username = username;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public UserDto(String username, String lastName, String firstName, String password, Set<String> authorities) {
        this.username = username;
        this.lastName = lastName;
        this.firstName = firstName;
        this.password = password;
        this.authorities = authorities;
    }

}
