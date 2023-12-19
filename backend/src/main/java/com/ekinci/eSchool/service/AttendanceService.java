package com.ekinci.eSchool.service;

import com.ekinci.eSchool.exception.ResourceNotFoundException;
import com.ekinci.eSchool.model.Attendance;
import com.ekinci.eSchool.model.SchoolClass;
import com.ekinci.eSchool.model.Student;
import com.ekinci.eSchool.repository.AttendanceRepository;
import com.ekinci.eSchool.repository.SchoolClassRepository;
import com.ekinci.eSchool.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SchoolClassRepository schoolClassRepository;

//    public List<Attendance> getAttendancesByClassAndDate(Long classId, LocalDate date){
//        return attendanceRepository.findBySClassIdAndAttendanceDate(classId,date);
//    }
    public List<Attendance> getAttendancesByStudentId(Long Id){
        return attendanceRepository.findByStudentId(Id);
    }


    public void saveAttendance(Long studentId, Long classId, LocalDate date, boolean isPresent,
                               LocalTime lateArrival, LocalTime earlyDeparture ) {

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() ->new ResourceNotFoundException("Student not found with " +studentId));

        SchoolClass sClass = schoolClassRepository.findById(classId)
                .orElseThrow(() ->new ResourceNotFoundException("Class not found with " +classId));


            Attendance attendance = new Attendance();
            attendance.setStudent(student);
            attendance.setSClass(sClass);
            attendance.setAttendanceDate(date);
            attendance.setPresent(isPresent);
            attendance.setLateArrival(lateArrival);
            attendance.setEarlyDeparture(earlyDeparture);
            attendanceRepository.save(attendance);



    }
}
