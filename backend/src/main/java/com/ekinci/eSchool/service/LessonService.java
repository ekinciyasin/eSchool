package com.ekinci.eSchool.service;

import com.ekinci.eSchool.dto.StudentLessonsOverview;
import com.ekinci.eSchool.repository.ExamRepository;
import com.ekinci.eSchool.repository.LessonRepository;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class LessonService {

    private LessonRepository lessonRepository;

    private ExamRepository examRepository;

//    private StudentLessonsOverview findLessonsOverview(String studentId){
//        List<StudentLessonsOverview> lessons = lessonRepository.findLessonsByStudentId(Long.valueOf(studentId));
//
//        List<Long> lessonsIds = lessons.stream().map(StudentLessonsOverview::getLessonId).toList();
//
//       return examRepository.findExamsByLessonId(lessonsIds);
//    }


}
