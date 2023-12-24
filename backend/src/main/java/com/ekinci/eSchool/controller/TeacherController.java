package com.ekinci.eSchool.controller;

import com.ekinci.eSchool.dto.TeacherInfoDTO;
import com.ekinci.eSchool.model.Teacher;
import com.ekinci.eSchool.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/1.0/teachers")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping
    public ResponseEntity<List<Teacher>> getAllTeachers() {
        List<Teacher> teachers = teacherService.getAllTeachers();
        return ResponseEntity.ok(teachers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Teacher> getTeacherById(@PathVariable Long id) {
        Teacher teacher = teacherService.getTeacherById(id);
        return ResponseEntity.ok(teacher);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Teacher>> searchStudents(@RequestParam("keyword") String keyword){
        List<Teacher> foundTeachers = teacherService.getTeachersByKeyword(keyword);
        return ResponseEntity.ok(foundTeachers);
    }

    @GetMapping("/search_info")
    public ResponseEntity<List<TeacherInfoDTO>> searchStudentsInfo(@RequestParam("keyword") String keyword){
        List<TeacherInfoDTO> foundTeachers = teacherService.getTeachersByKeyword2(keyword);
        return ResponseEntity.ok(foundTeachers);
    }
    @PostMapping
    public ResponseEntity<Teacher> createTeacher(@RequestBody Teacher teacher) {
        Teacher createdTeacher = teacherService.createTeacher(teacher);
        return ResponseEntity.ok(createdTeacher);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Teacher> updateTeacher(@PathVariable Long id, @RequestBody Teacher teacher) {
        Teacher updatedTeacher = teacherService.updateTeacher(id, teacher);
        return ResponseEntity.ok(updatedTeacher);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeacher(@PathVariable Long id) {
        teacherService.deleteTeacher(id);
        return ResponseEntity.noContent().build();
    }
}

