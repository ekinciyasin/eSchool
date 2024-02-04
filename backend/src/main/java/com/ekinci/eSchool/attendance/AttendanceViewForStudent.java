package com.ekinci.eSchool.attendance;

import com.ekinci.eSchool.dto.GradeView.LessonDto;
import com.ekinci.eSchool.model.model.Lesson;
import com.ekinci.eSchool.student.Student;
import com.ekinci.eSchool.student.StudentDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor
@Setter
@Getter
public class AttendanceViewForStudent {

    private Long id;


    private StudentDto student;


    private String  lessonName;


    private boolean isPresent;


    private boolean isExcused;


    private LocalDate attendanceDate;


    private LocalTime lateArrival;

    private LocalTime earlyDeparture;

    public AttendanceViewForStudent(Long id, StudentDto student, LessonDto lessonDto, boolean isPresent, boolean isExcused, LocalDate attendanceDate, LocalTime lateArrival, LocalTime earlyDeparture) {
        this.id = id;
        this.student = student;
        this.lessonName = lessonDto.getName();
        this.isPresent = isPresent;
        this.isExcused = isExcused;
        this.attendanceDate = attendanceDate;
        this.lateArrival = lateArrival;
        this.earlyDeparture = earlyDeparture;
    }
}
