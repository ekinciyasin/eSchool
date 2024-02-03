package com.ekinci.eSchool.model.model;

import com.ekinci.eSchool.util.Views;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "exams")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonView(Views.GradeView.class)
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;


    private String name;

    @ManyToOne
    @JoinColumn(name="lesson_id",nullable = false)
    private Lesson lesson;

    private LocalDate localDate;

}
