package com.ekinci.eSchool.service;

import com.ekinci.eSchool.model.Exam;
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

    public List<Exam> getGradesByStudentId(Long studentId) {
        return gradeRepository.findByStudentId(studentId);
    }

    public Exam addGrade(Long studentId, Exam exam) {
        Student student = studentService.getStudentById(studentId);
        exam.setStudent(student);
        notificationService.sendGradeNotification(studentId, exam.getSubject(), exam.getScore());
        return gradeRepository.save(exam);
    }
}
