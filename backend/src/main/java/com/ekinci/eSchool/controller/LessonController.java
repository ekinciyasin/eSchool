package com.ekinci.eSchool.controller;

import com.ekinci.eSchool.service.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/1.0/lessons")
@RequiredArgsConstructor
public class LessonController {

    private final LessonService lessonService;

//    @GetMapping("/student/{studentId}")
//    public ResponseEntity<StudentLessonOverview> findLessonsOfStudent(@RequestParam String studentId){
//
//    }
}
