package com.ekinci.eSchool.service;

import com.ekinci.eSchool.user.UserDto;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SecurityService {

    public String getUsernameFromPrincipal() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();

        if (principal instanceof UserDto) {
            UserDto userDto = (UserDto) principal;
            return userDto.getUsername();
        }

        throw new UsernameNotFoundException("Kullanıcı adı alınamadı.");
    }
}
