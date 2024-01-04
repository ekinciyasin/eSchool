package com.ekinci.eSchool.repository;



import com.ekinci.eSchool.model.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GradeRepository extends JpaRepository<Exam, Long> {

    List<Exam> findByStudentId(Long studentId);


}