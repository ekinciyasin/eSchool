package com.ekinci.eSchool.model.dto;

import lombok.*;

import java.util.List;
import java.util.Set;


public class TeacherDTO extends UserDTO{
    private String subjectTaught;

    public TeacherDTO() {

    }

    public TeacherDTO(String username, String lastName, String firstName, Set<String> authorities, String subjectTaught) {
        super(username, lastName, firstName, authorities);
        this.subjectTaught = subjectTaught;
    }

    public String getSubjectTaught() {
        return subjectTaught;
    }

    public void setSubjectTaught(String subjectTaught) {
        this.subjectTaught = subjectTaught;
    }
}
