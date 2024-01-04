package com.ekinci.eSchool.controller;

import com.ekinci.eSchool.model.Exam;

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
    public ResponseEntity<List<Exam>> getGradesByStudentId(@PathVariable Long studentId) {
        List<Exam> exams = gradeService.getGradesByStudentId(studentId);
        return ResponseEntity.ok(exams);
    }

    @PostMapping("/students/{studentId}")
    public ResponseEntity<Exam> addGrade(@PathVariable Long studentId, @RequestBody Exam exam) {
        Exam addedExam = gradeService.addGrade(studentId, exam);
        return ResponseEntity.ok(addedExam);
    }

    @GetMapping("/notifications/{studentId}")
    public ResponseEntity<List<Notification>> getNotificationsByStudentId(@PathVariable Long studentId) {
        List<Notification> notifications = notificationService.getNotificationsByStudentId(studentId);
        return ResponseEntity.ok(notifications);
    }



}
