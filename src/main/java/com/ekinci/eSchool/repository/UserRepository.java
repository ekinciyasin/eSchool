package com.ekinci.eSchool.repository;

import com.ekinci.eSchool.model.Student;
import com.ekinci.eSchool.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
//    @Query("SELECT s FROM Student s WHERE " +
//            "LOWER(s.firstName) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
//            "LOWER(s.lastName) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
//            "LOWER(s.email) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
//            "LOWER(s.contactNumber) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
//            "LOWER(s.address) LIKE LOWER(CONCAT('%', :keyword, '%'))")
//    List<Student> searchStudents(@Param("keyword") String keyword);
}
