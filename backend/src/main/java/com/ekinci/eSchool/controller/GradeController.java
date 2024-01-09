package com.ekinci.eSchool.controller;

import com.ekinci.eSchool.dto.GradeView.GradeViewForStudent;
import com.ekinci.eSchool.model.Exam;

import com.ekinci.eSchool.model.Grade;
import com.ekinci.eSchool.model.Notification;
import com.ekinci.eSchool.service.GradeService;
import com.ekinci.eSchool.service.NotificationService;
import com.ekinci.eSchool.util.Views;
import com.fasterxml.jackson.annotation.JsonView;
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

    @JsonView(Views.GradeView.class)
    @GetMapping("/{studentId}")
    public ResponseEntity<List<Grade>> getGradesByStudentIdWithJsonView(@PathVariable Long studentId) {
        List<Grade> grades = gradeService.getGradesByStudentId(studentId);
        return ResponseEntity.ok(grades);
    }


    @GetMapping("/projection/{studentId}")
    public ResponseEntity<List<GradeViewForStudent>> getGradesByStudentIdWithProjection(@PathVariable Long studentId) {
        List<GradeViewForStudent> grades = gradeService.getGradesByStudentIdWithProjection(studentId);
        return ResponseEntity.ok(grades);
    }

    @PostMapping("/{studentId}")
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
