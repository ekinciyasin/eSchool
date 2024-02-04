package com.ekinci.eSchool.attendance;

import com.ekinci.eSchool.attendance.Attendance;
import com.ekinci.eSchool.attendance.AttendanceViewForStudent;
import com.ekinci.eSchool.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    @Query("""
            SELECT new com.ekinci.eSchool.attendance.AttendanceViewForStudent(
            a.id,
            new com.ekinci.eSchool.student.StudentDto(s.id, s.firstName, s.lastName),
            new com.ekinci.eSchool.dto.GradeView.LessonDto(l.id, l.name),
            a.isPresent,
            a.isExcused,
            a.attendanceDate,
            a.lateArrival,
            a.earlyDeparture
            )
            FROM Attendance a
            JOIN a.student.user s      
            JOIN a.lesson l
            WHERE s.id = :studentId
            """)
    List<AttendanceViewForStudent> getAttendancesByStudentWithProjection(@Param("studentId")Long studentId);

//    List<Attendance> findBySClassIdAndAttendanceDate(Long classId, LocalDate date);

    List<Attendance> findByStudentId(Long id);

}
