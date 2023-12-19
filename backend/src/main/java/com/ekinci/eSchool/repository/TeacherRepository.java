package com.ekinci.eSchool.repository;

import com.ekinci.eSchool.model.Student;
import com.ekinci.eSchool.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long> {
    @Query("SELECT t FROM Teacher t WHERE " +
            "LOWER(t.user.firstName) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(t.user.lastName) LIKE LOWER(CONCAT('%', :keyword, '%'))")
//            "LOWER(t.email) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
//            "LOWER(s.contactNumber) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
//            "LOWER(s.address) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Teacher> searchTearchers(@Param("keyword") String keyword);
}
