package com.ekinci.eSchool.controller;

import com.ekinci.eSchool.dto.StudentInfoDTO;
import com.ekinci.eSchool.model.Student;
import com.ekinci.eSchool.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/1.0/students")
public class StudentController {


    private StudentService studentService;

    public StudentController(StudentService studentService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student){

        Student createdStudent = studentService.createStudent(student);
       return ResponseEntity.ok(createdStudent);
    }
    @GetMapping
    public ResponseEntity<List<Student>> getStudents(){

    List<Student> students = studentService.getStudents();
       return ResponseEntity.ok().body(students);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Student>> searchStudents(@RequestParam("keyword") String keyword){
        List<Student> foundStudents = studentService.getStudentsByKeyword(keyword);
        return ResponseEntity.ok(foundStudents);
    }
@GetMapping("/search_info")
    public ResponseEntity<List<StudentInfoDTO>> searchStudentsInfo(@RequestParam("keyword") String keyword){
        List<StudentInfoDTO> foundStudents = studentService.getStudentsInfoByKeyword(keyword);
        return ResponseEntity.ok(foundStudents);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student) {
        Student updatedStudent = studentService.updateStudent(id, student);
        return ResponseEntity.ok(updatedStudent);
    }
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
    }

}
