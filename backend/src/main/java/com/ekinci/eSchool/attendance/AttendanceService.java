package com.ekinci.eSchool.attendance;

import com.ekinci.eSchool.exception.ResourceNotFoundException;
import com.ekinci.eSchool.student.Student;
import com.ekinci.eSchool.student.StudentRepository;
import com.ekinci.eSchool.student.StudentService;
import com.ekinci.eSchool.user.User;
import com.ekinci.eSchool.user.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class AttendanceService {
    private AttendanceRepository attendanceRepository;
    private StudentRepository studentRepository;
    private StudentService studentService;
    private UserRepository userRepository;

    public AttendanceService(AttendanceRepository attendanceRepository, StudentRepository studentRepository, StudentService studentService, UserRepository userRepository) {
        this.attendanceRepository = attendanceRepository;
        this.studentRepository = studentRepository;
        this.studentService = studentService;
        this.userRepository = userRepository;
    }

    //    public List<Attendance> getAttendancesByClassAndDate(Long classId, LocalDate date){
//        return attendanceRepository.findBySClassIdAndAttendanceDate(classId,date);
//    }
    public List<Attendance> getAttendancesByStudentId(Long Id){
        return attendanceRepository.findByStudentId(Id);
    }


    public void saveAttendance(Long studentId, Long classId, LocalDate date, boolean isPresent,
                               LocalTime lateArrival, LocalTime earlyDeparture ) {

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() ->new ResourceNotFoundException("Student not found with " +studentId , HttpStatus.NOT_FOUND ));



            Attendance attendance = new Attendance();
            attendance.setStudent(student);

            attendance.setAttendanceDate(date);
            attendance.setPresent(isPresent);
            attendance.setLateArrival(lateArrival);
            attendance.setEarlyDeparture(earlyDeparture);
            attendanceRepository.save(attendance);



    }

    public List<AttendanceViewForStudent> getAttendancesByStudentId(String authenticatedUsername) {
        User user = userRepository.findByUsername(authenticatedUsername);
        Student studentByUserId = studentService.getStudentByUserId(user.getId());
        return attendanceRepository.getAttendancesByStudentWithProjection(studentByUserId.getId());
    }
}
