package com.ekinci.eSchool.service.conversion;

import com.ekinci.eSchool.model.model.Role;
import com.ekinci.eSchool.teacher.Teacher;
import com.ekinci.eSchool.dto.TeacherInfoDTO;
import org.springframework.security.core.GrantedAuthority;

import java.util.stream.Collectors;

public class TeacherConversionService {

    public TeacherInfoDTO convertoDto(Teacher teacher){
        TeacherInfoDTO teacherDTO = new TeacherInfoDTO();
        teacherDTO.setUsername(teacher.getUser().getUsername());
        teacherDTO.setRoles(
                teacher.getUser().getRoles()
                        .stream()
                        .map(GrantedAuthority::getAuthority) // GrantedAuthority'den String'e dönüşüm
                        .map(Role::valueOf) // String'den Role'e dönüşüm
                        .collect(Collectors.toSet())
        );
        teacherDTO.setFirstName(teacher.getUser().getFirstName());
        teacherDTO.setLastName(teacher.getUser().getLastName());
    return teacherDTO;

    }
}
