package com.ekinci.eSchool.controller;

import com.ekinci.eSchool.config.UserAuthenticationProvider;
import com.ekinci.eSchool.dto.CredentialsDto;
import com.ekinci.eSchool.dto.UserDto;
import com.ekinci.eSchool.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class AuthController {

    private final UserService userService;
    private final UserAuthenticationProvider userAuthenticationProvider;

    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody @Valid CredentialsDto credentialsDto) {
        UserDto userDto = userService.login(credentialsDto);
        userDto.setToken(userAuthenticationProvider.createToken(userDto));
        return ResponseEntity.ok(userDto);
    }

//    @PostMapping("/register")
//    public ResponseEntity<UserDto> register(@RequestBody @Valid SignUpDto user) {
//        UserDto createdUser = userService.register(user);
//        createdUser.setToken(userAuthenticationProvider.createToken(user.getLogin()));
//        return ResponseEntity.created(URI.create("/users/" + createdUser.getId())).body(createdUser);
//    }

}