package com.ekinci.eSchool.model;

import com.ekinci.eSchool.util.Views;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "lessons")
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(Views.GradeView.class)
    private Long id;

    @JsonView(Views.GradeView.class)
    private String name;

    @ManyToOne
    private Teacher teacher;

    @ManyToMany(mappedBy = "lessons")

    private List<Student> students;


}
