package com.ekinci.eSchool.controller;

import com.ekinci.eSchool.model.Student;
import com.ekinci.eSchool.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/1.0/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        Student createdStudent = studentService.createStudent(student);
       return ResponseEntity.ok(createdStudent);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Student>> searchStudents(@RequestParam("keyword") String keyword){
        List<Student> foundStudents = studentService.getStudentsByKeyword(keyword);
        return ResponseEntity.ok(foundStudents);
    }


}
