package com.ekinci.eSchool.model;


import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ROLE_TEACHER("TEACHER"),
    ROLE_STUDENT("STUDENT"),
    ROLE_ADMIN("ADMIN");

    private String value;

    Role(String value) {
         this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String getAuthority() {
        return name();
    }
}