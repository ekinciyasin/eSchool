package com.ekinci.eSchool.service;

import com.ekinci.eSchool.dto.CredentialsDto;
import com.ekinci.eSchool.dto.UserDto;
import com.ekinci.eSchool.exception.ResourceNotFoundException;
import com.ekinci.eSchool.mapper.UserMapper;
import com.ekinci.eSchool.model.User;
import com.ekinci.eSchool.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.CharBuffer;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    private final UserMapper userMapper;




    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
    }

    public UserDto login(CredentialsDto credentialsDto) {
        System.out.println(credentialsDto.username());

//        UserDto user = userRepository.findByUsernameWithQuery(credentialsDto.username())
        User user = userRepository.findByUsername(credentialsDto.username());
//                .orElseThrow(() -> new ResourceNotFoundException("Unknown user", HttpStatus.UNAUTHORIZED));

        if (passwordEncoder.matches(CharBuffer.wrap(credentialsDto.password()), user.getPassword())) {
            return userMapper.toDto(user);
        }
        throw new ResourceNotFoundException("Invalid password", HttpStatus.BAD_REQUEST);
    }

    public UserDto getByUsername(String username){
        UserDto userDto = userRepository.findByUsernameWithQuery(username)
                .orElseThrow(() -> new ResourceNotFoundException("Unknown user", HttpStatus.NOT_FOUND));
        return userDto;
    }



}
