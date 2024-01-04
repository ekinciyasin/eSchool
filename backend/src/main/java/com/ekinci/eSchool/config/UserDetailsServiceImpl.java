//package com.ekinci.eSchool.config;
//
//import com.ekinci.eSchool.dto.UserDto;
//import com.ekinci.eSchool.model.User;
//import com.ekinci.eSchool.service.UserService;
//import jakarta.persistence.EntityNotFoundException;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//
//    private final UserService userService;
//
//    public UserDetailsServiceImpl(UserService userService) {
//        this.userService = userService;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        UserDto user = userService.getByUsername(username);
//        if (user.isPresent()) {
//            // Kullanıcı bulunduysa UserDetails döndür
//            return user.map(u -> (UserDetails) u).get();
//        } else {
//            // Kullanıcı bulunamadıysa UsernameNotFoundException fırlat
//            throw new UsernameNotFoundException("Kullanıcı bulunamadı: " + username);
//        }
//    }
//}
