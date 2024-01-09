package com.ekinci.eSchool.repository;

import com.ekinci.eSchool.model.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExamRepository extends JpaRepository<Exam, Long> {


    @Query(value= """
            select e from Exam e join e.lesson l where l.id in (:lessonId)

            """)
    public List<Exam> findExamsByLessonId(List<Long> lessonId);


}
