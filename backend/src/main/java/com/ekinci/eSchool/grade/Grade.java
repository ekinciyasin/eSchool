package com.ekinci.eSchool.model;

import com.ekinci.eSchool.util.Views;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@JsonView(Views.GradeView.class)
public class Grade {
    @Id
    private Long id;

    @Column(name = "grade_value", nullable = false, columnDefinition = "integer default 0")
    public int gradeValue;

//    @JsonView(Views.GradeView.class)
    @ManyToOne
    private Student student;


    @ManyToOne
    private Exam exam;

//    @Override
//    public String toString() {
//        return "Grade{" +
//                "id=" + id +
//                ", gradeValue=" + gradeValue +
//                ", student=" + student +
//                ", exam=" + exam +
//                '}';
//    }
}
