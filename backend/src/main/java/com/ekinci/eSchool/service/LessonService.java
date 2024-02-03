package com.ekinci.eSchool.service;

import com.ekinci.eSchool.model.model.Lesson;
import com.ekinci.eSchool.student.Student;
import com.ekinci.eSchool.repository.ExamRepository;
import com.ekinci.eSchool.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class LessonService {


    private LessonRepository lessonRepository;

    private ExamRepository examRepository;

    @Autowired
    public LessonService(LessonRepository lessonRepository, ExamRepository examRepository) {
        this.lessonRepository = lessonRepository;
        this.examRepository = examRepository;
    }

    public  List<Lesson>  getLessonsByStudent(Student studentByUserId) {
        return lessonRepository.findByStudents_Id(studentByUserId.getId());
    }

//    private StudentLessonsOverview findLessonsOverview(String studentId){
//        List<StudentLessonsOverview> lessons = lessonRepository.findLessonsByStudentId(Long.valueOf(studentId));
//
//        List<Long> lessonsIds = lessons.stream().map(StudentLessonsOverview::getLessonId).toList();
//
//       return examRepository.findExamsByLessonId(lessonsIds);
//    }


}
