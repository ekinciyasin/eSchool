package com.ekinci.eSchool.teacher;

import com.ekinci.eSchool.model.model.Lesson;
import com.ekinci.eSchool.user.User;
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

    @OneToMany
    private List<Lesson> lessons;

    public Teacher(User user) {

        this.user = user;
    }


}
