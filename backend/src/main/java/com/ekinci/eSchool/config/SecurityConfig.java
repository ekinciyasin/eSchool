package com.ekinci.eSchool.config;

import com.ekinci.eSchool.auth.JwtAuthFilter;
import com.ekinci.eSchool.model.model.Role;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig{
    private final UserAuthenticationProvider userAuthProvider;

    public SecurityConfig(UserAuthenticationProvider userAuthProvider) {
        this.userAuthProvider = userAuthProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        http
                .headers(headers ->headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable))
                .addFilterBefore(new JwtAuthFilter(userAuthProvider), BasicAuthenticationFilter.class)
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests((authz) -> {
                    authz.requestMatchers("/api/1.0/teachers/**").hasAnyRole(Role.ROLE_ADMIN.getValue(), Role.ROLE_TEACHER.getValue());
                    authz.requestMatchers("/api/1.0/grades/**").hasAnyRole(Role.ROLE_ADMIN.getValue(), Role.ROLE_STUDENT.getValue());
                    authz.anyRequest().permitAll();});



        return http.build();

    }
}
