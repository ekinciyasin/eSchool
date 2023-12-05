package com.ekinci.eSchool.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "classes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SchoolClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "class_name", nullable = false)
    private String className;

    @Column(name = "class_code", unique = true, nullable = false)
    private String classCode;

    @Column(name = "class_description")
    private String classDescription;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

}