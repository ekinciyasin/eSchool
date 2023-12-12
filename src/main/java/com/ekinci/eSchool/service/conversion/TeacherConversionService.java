package com.ekinci.eSchool.service.conversion;

import com.ekinci.eSchool.model.Teacher;
import com.ekinci.eSchool.model.dto.TeacherDTO;

import java.util.stream.Collectors;

public class TeacherConversionService {

    public TeacherDTO convertoDto(Teacher teacher){
        TeacherDTO teacherDTO = new TeacherDTO();
        teacherDTO.setUsername(teacher.getUser().getUsername());
        teacherDTO.setAuthorities(teacher.getUser().getAuthorities().stream().map(Object::toString).collect(Collectors.toSet()));
        teacherDTO.setFirstName(teacher.getUser().getFirstName());
        teacherDTO.setLastName(teacher.getUser().getLastName());
    return teacherDTO;

    }
}
