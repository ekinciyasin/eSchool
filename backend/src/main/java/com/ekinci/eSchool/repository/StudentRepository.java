package com.ekinci.eSchool.repository;

import com.ekinci.eSchool.dto.StudentInfoDTO;
import com.ekinci.eSchool.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    @Query("SELECT s FROM Student s WHERE " +
            "LOWER(s.user.firstName) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(s.user.lastName) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(s.email) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(s.contactNumber) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(s.address) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Student> searchStudents(@Param("keyword") String keyword);

    @Query("SELECT new com.ekinci.eSchool.dto.StudentInfoDTO(s.user.username, " +
            "s.user.lastName, " +
            "s.user.firstName," +
            // "t.user.authorities," +
            "s.dateOfBirth," +
            "s.gender," +
            "s.email," +
            "s.contactNumber," +
            "s.address) " +
            "FROM Student s " +
            "WHERE LOWER(s.user.firstName) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(s.user.lastName) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(s.email) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<StudentInfoDTO> findStudentsInfoByKeyword(String keyword);
}
