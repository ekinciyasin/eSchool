package com.ekinci.eSchool.service;

import com.ekinci.eSchool.exception.ResourceNotFoundException;
import com.ekinci.eSchool.model.SchoolClass;
import com.ekinci.eSchool.model.Teacher;
import com.ekinci.eSchool.repository.SchoolClassRepository;
import com.ekinci.eSchool.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SchoolClassService {

    @Autowired private SchoolClassRepository schoolClassRepository;

    @Autowired private TeacherRepository teacherRepository;

            public SchoolClass saveSchoolClass(String classCode,String className, String classDescription, Long teacherId){
                Teacher teacher = teacherRepository.findById(teacherId).orElseThrow(()-> new ResourceNotFoundException("Teacher not found with " + teacherId));

             return     schoolClassRepository.save(SchoolClass.builder()
                        .classCode(classCode)
                        .className(className)
                        .classDescription(classDescription)
                        .teacher(teacher)
                        .build());
            }


    public List<SchoolClass> getSchoolClasses() {
        return schoolClassRepository.findAll();
    }
}
