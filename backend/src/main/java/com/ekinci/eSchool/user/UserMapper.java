package com.ekinci.eSchool.user;

import com.ekinci.eSchool.model.model.Role;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class UserMapper {

    public UserDto toDto(User entity) {
        return UserDto.builder()
                .username(entity.getUsername())
                .lastName(entity.getLastName())
                .firstName(entity.getFirstName())
                .password(entity.getPassword())
                .email(entity.getEmail())
                .roles((Set<Role>) entity.getRoles())

                .build();
    }

    public User toEntity(UserDto dto) {
        return User.builder()
                .username(dto.getUsername())
                .lastName(dto.getLastName())
                .firstName(dto.getFirstName())
                .password(dto.getPassword())
                .email(dto.getEmail())
                .roles(dto.getRoles())

                .build();
    }
}
