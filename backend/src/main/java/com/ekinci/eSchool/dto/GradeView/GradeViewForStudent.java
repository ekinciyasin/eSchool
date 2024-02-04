package com.ekinci.eSchool.dto.GradeView;

import com.ekinci.eSchool.dto.ExamDto;
import com.ekinci.eSchool.student.StudentDto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter

public class GradeViewForStudent {
    private long gradeId;
    private int gradeValue;

    private StudentDto student;
    private LessonDto lesson;
    private ExamDto exam;


    public GradeViewForStudent() {
        this.lesson = new LessonDto();
    }

    public GradeViewForStudent(long gradeId, int gradeValue, StudentDto student, LessonDto lesson, ExamDto exam) {
        this.gradeId = gradeId;
        this.gradeValue = gradeValue;
        this.student = student;
        this.lesson = lesson;
        this.exam = exam;
    }

    public GradeViewForStudent(long gradeId, int gradeValue, Long studentId, String  firstName, String lastName, Long lessonId, String lessonName, Long examId, String examName, LocalDate examDate) {
        this.gradeId = gradeId;
        this.gradeValue = gradeValue;

        this.student =new StudentDto(studentId,firstName,lastName);
        this.lesson = new LessonDto(lessonId,lessonName);
        this.exam = new ExamDto(examId,examName,examDate);
    }
}


