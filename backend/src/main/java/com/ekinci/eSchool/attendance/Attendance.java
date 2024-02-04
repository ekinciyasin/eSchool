package com.ekinci.eSchool.attendance;

import com.ekinci.eSchool.model.model.Lesson;
import com.ekinci.eSchool.student.Student;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "attendances")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="student_id", nullable = false)
    private Student student;

    @ManyToOne
    private Lesson lesson;

    @Column(name= "is_present", nullable = false)
    private boolean isPresent;

    @Column(name= "is_excused")
    private boolean isExcused;

    @Column(name = "attendance_date", nullable = false)
    private LocalDate attendanceDate;

    @Column(name="late_arrival")
    private LocalTime lateArrival;

    private LocalTime earlyDeparture;
}
