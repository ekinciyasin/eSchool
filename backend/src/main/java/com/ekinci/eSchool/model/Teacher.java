package com.ekinci.eSchool.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @OneToOne(cascade = CascadeType.PERSIST)
    private User user;

    @Column(name = "subject_taught", nullable = false)
    private String subjectTaught;

    @OneToMany
    private List<Lesson> lessons;
}
