//package com.ekinci.eSchool.config;
//
//import com.ekinci.eSchool.model.User;
//import com.ekinci.eSchool.repository.UserRepository;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//import java.util.Optional;
//
//public class DatabaseUserDetailsAuthenticationProvider implements AuthenticationProvider {
//
//    private final UserDetailsService userDetailsService;
//    private final UserRepository userRepository;
//
//
//    public DatabaseUserDetailsAuthenticationProvider(UserDetailsService userDetailsService) {
//        this.userDetailsService = userDetailsService;
//    }
//
//
//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        String username = authentication.getName();
//        String password = (String) authentication.getCredentials();
//        Optional<User> user = userRepository.findByUsername(username);
//        if (user == null) {
//            throw new UsernameNotFoundException("User not found with username: " + username);
//        }
//        // Get the user details from the database
//        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
//
//        // Check if the username and password are valid
//        if (userDetails == null || !passwordEncoder.matches(password, userDetails.getPassword())) {
//            throw new BadCredentialsException("Invalid username or password");
//        }
//
//        // Create a new Authentication object
//        Authentication authenticatedUser = new UsernamePasswordAuthenticationToken(
//                userDetails, null, userDetails.getAuthorities());
//
//    }
//
//    @Override
//    public boolean supports(Class<?> authentication) {
//        return false;
//    }
//}
