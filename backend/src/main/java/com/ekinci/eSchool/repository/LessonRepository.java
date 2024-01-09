package com.ekinci.eSchool.repository;

import com.ekinci.eSchool.dto.StudentLessonsOverview;
import com.ekinci.eSchool.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LessonRepository extends JpaRepository<Lesson, Long> {

    @Query("""
            SELECT new com.ekinci.eSchool.dto.StudentLessonsOverview(
            l.id, l.name) 
            FROM Lesson l JOIN l.students s
            WHERE s.id = :studentId
            """)
    List<StudentLessonsOverview> findLessonsByStudentId(@Param("studentId") Long studentId);
}
