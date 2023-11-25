package com.ekinci.eSchool.service;

import com.ekinci.eSchool.model.Student;
import com.ekinci.eSchool.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    public StudentRepository studentRepository;
    public Student createStudent(Student student) {
        Student savedStudent = studentRepository.save(student);
        return savedStudent;
    }

    public List<Student> getStudentsByKeyword(String keyword) {
        return studentRepository.searchStudents(keyword);

    }
}
