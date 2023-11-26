package com.ekinci.eSchool.controller;

import com.ekinci.eSchool.model.Grade;

import com.ekinci.eSchool.model.Notification;
import com.ekinci.eSchool.service.GradeService;
import com.ekinci.eSchool.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/1.0/grades")
public class GradeController {

    @Autowired
    private GradeService gradeService;

    @Autowired
    private NotificationService notificationService;

    @GetMapping("/students/{studentId}")
    public ResponseEntity<List<Grade>> getGradesByStudentId(@PathVariable Long studentId) {
        List<Grade> grades = gradeService.getGradesByStudentId(studentId);
        return ResponseEntity.ok(grades);
    }

    @PostMapping("/students/{studentId}")
    public ResponseEntity<Grade> addGrade(@PathVariable Long studentId, @RequestBody Grade grade) {
        Grade addedGrade = gradeService.addGrade(studentId, grade);
        return ResponseEntity.ok(addedGrade);
    }

    @GetMapping("/notifications/{studentId}")
    public ResponseEntity<List<Notification>> getNotificationsByStudentId(@PathVariable Long studentId) {
        List<Notification> notifications = notificationService.getNotificationsByStudentId(studentId);
        return ResponseEntity.ok(notifications);
    }



}
