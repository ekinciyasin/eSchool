package com.ekinci.eSchool.dto;

import com.ekinci.eSchool.model.Role;
import lombok.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class UserDto {
    private String username;
    private String lastName;
    private String firstName;
    private String password;
    private String email;
    private Set<Role> roles;
    private String token;




    public UserDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

//    public UserDto(String username, String lastName, String firstName, String password) {
//        this.username = username;
//        this.lastName = lastName;
//        this.firstName = firstName;
//        this.password = password;
//
//    }

    public UserDto(String username, String lastName, String firstName,String email,String password) {
        this.username = username;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email =email;
        this.password=password;
    }

    public UserDto(String username, String lastName, String firstName, String password, String email, Set<Role> roles) {
        this.username = username;
        this.lastName = lastName;
        this.firstName = firstName;
        this.password = password;
        this.email = email;
        this.roles = roles;
    }
//    public UserDto(String username, String lastName, String firstName, String password, String email, Set<String> roles) {
//        this.username = username;
//        this.lastName = lastName;
//        this.firstName = firstName;
//        this.password = password;
//        this.email = email;
//        this.roles = roles.stream().map(Role::valueOf).collect(Collectors.toSet());
//    }


    public UserDto(String username, String lastName, String firstName, String password, Set<Role> roles) {
        this.username = username;
        this.lastName = lastName;
        this.firstName = firstName;
        this.password = password;
        this.roles = roles;
    }

    public UserDto(String username, String lastName, String firstName, String email) {
        this.username = username;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
    }

}
