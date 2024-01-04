package com.ekinci.eSchool.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "exams")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;

    @ManyToOne
    @JoinColumn(name="student_id",nullable = false)
    private Student student;

    @Column(name = "subject", nullable = false)
    private String subject;

    @ManyToMany(mappedBy = "exams")
    private List<Lesson> lessons;

    @Column(name = "score", nullable = false)
    private double score;

}
