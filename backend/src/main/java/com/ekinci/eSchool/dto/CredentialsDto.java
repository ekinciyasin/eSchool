package com.ekinci.eSchool.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


public record CredentialsDto(

        @NotBlank
        @Size(min = 4,max=255)
//        @Pattern(regexp = "^[a-zA-Z0-9_-]+$")
        String username,
        @Size(min = 6, message = "Password must be at least 6 characters long")
        char[] password)

{}
