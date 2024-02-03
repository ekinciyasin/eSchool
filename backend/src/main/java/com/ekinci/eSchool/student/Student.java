package com.ekinci.eSchool.student;

import com.ekinci.eSchool.model.model.Gender;
import com.ekinci.eSchool.model.model.Lesson;
import com.ekinci.eSchool.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "students")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
    private User user;


    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    @Column(name = "gender", nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;



    @Column(name = "contact_number", nullable = false)
    private String contactNumber;


    @Column(name = "address")
    private String address;

    @ManyToMany
    @JoinTable(
            name = "student_lesson",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "lesson_id")
    )

    private List<Lesson> lessons;



    public String getFullName() {
        return this.user.getFirstName() +" "+ this.user.getLastName();
    }
}
