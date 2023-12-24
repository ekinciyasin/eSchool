package com.ekinci.eSchool.dto;


public class TeacherInfoDTO extends com.ekinci.eSchool.dto.UserDTO {
    private String subjectTaught;

    public TeacherInfoDTO() {

    }

    public TeacherInfoDTO(String username,
                          String lastName,
                          String firstName,
                          //Set<Role> authorities,
                          String subjectTaught) {
        super(username, lastName, firstName
               // authorities
        );
        this.subjectTaught = subjectTaught;
    }

    public String getSubjectTaught() {
        return subjectTaught;
    }

    public void setSubjectTaught(String subjectTaught) {
        this.subjectTaught = subjectTaught;
    }
}
