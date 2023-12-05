package com.ekinci.eSchool.repository;

import com.ekinci.eSchool.model.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
//    List<Attendance> findBySClassIdAndAttendanceDate(Long classId, LocalDate date);

    List<Attendance> findByStudentId(Long id);
}
