package com.ekinci.eSchool.dto;


import com.ekinci.eSchool.user.UserDto;

public class TeacherInfoDTO extends UserDto {


    public TeacherInfoDTO() {

    }

    public TeacherInfoDTO(String username,
                          String lastName,
                          String firstName,
                          String email
                          //Set<Role> authorities,
                       ) {
        super(username, lastName, firstName,email
               // authorities
        );

    }



}
