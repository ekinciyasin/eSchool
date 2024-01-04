package com.ekinci.eSchool.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CredentialsDto(
        @NotNull(message = "Login cannot be null")
        String username,
        @Size(min = 6, message = "Password must be at least 6 characters long")
        char[] password)

{}
