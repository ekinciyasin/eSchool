package com.ekinci.eSchool.service;

import com.ekinci.eSchool.model.Grade;
import com.ekinci.eSchool.model.Student;
import com.ekinci.eSchool.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeService {
    @Autowired
    private GradeRepository gradeRepository;

    @Autowired
    private StudentService studentService;

    @Autowired
    private NotificationService notificationService;

    public List<Grade> getGradesByStudentId(Long studentId) {
        return gradeRepository.findByStudentId(studentId);
    }

    public Grade addGrade(Long studentId, Grade grade) {
        Student student = studentService.getStudentById(studentId);
        grade.setStudent(student);
        notificationService.sendGradeNotification(studentId, grade.getSubject(), grade.getScore());
        return gradeRepository.save(grade);
    }
}
