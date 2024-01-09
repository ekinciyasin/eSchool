package com.ekinci.eSchool.repository;



import com.ekinci.eSchool.dto.GradeView.GradeViewForStudent;
import com.ekinci.eSchool.model.Exam;
import com.ekinci.eSchool.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Long> {

    List<Grade> findByStudentId(Long id);

    @Query("""
            SELECT new com.ekinci.eSchool.dto.GradeView.GradeViewForStudent(
            g.id,
            g.gradeValue,
            new com.ekinci.eSchool.dto.GradeView.StudentDto(s.id, s.firstName, s.lastName),
            new com.ekinci.eSchool.dto.GradeView.LessonDto(l.id, l.name),
            new com.ekinci.eSchool.dto.ExamDto(e.id, e.name, e.localDate)
            )
            FROM Grade g
            JOIN g.student.user s
            JOIN g.exam e
            JOIN e.lesson l
            WHERE s.id = :studentId
            """)
    List<GradeViewForStudent> findByStudentIdWithProjection(Long studentId);


//    @Query("""
//            SELECT new com.ekinci.eSchool.dto.GradeView.GradeViewForStudent(
//            g.id, g.gradeValue,
//            g.student.id, g.student.user.firstName, g.student.user.lastName,
//            g.exam.lesson.id, g.exam.lesson.name,
//            g.exam.id, g.exam.name, g.exam.localDate)
//            FROM Grade g
//            WHERE g.student.id = :studentId
//            """)
//    List<GradeViewForStudent> findByStudentIdWithProjection(Long studentId);

}