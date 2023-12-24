package com.ekinci.eSchool.controller;

import com.ekinci.eSchool.model.Attendance;
import com.ekinci.eSchool.dto.AttendanceDTO;
import com.ekinci.eSchool.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/1.0/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

//    @GetMapping("/class/{classId}/date/{date}")
//    public ResponseEntity<List<Attendance>> getAttendancesByClassAndDate(
//            @PathVariable Long classId, @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
//        List<Attendance> attendances = attendanceService.getAttendancesByClassAndDate(classId, date);
//        return ResponseEntity.ok(attendances);
//    }
@GetMapping("/{studentId}")
    public ResponseEntity<List<Attendance>> getAttendancesByStudentId(
            @PathVariable Long studentId) {
        List<Attendance> attendances = attendanceService.getAttendancesByStudentId(studentId);
        return ResponseEntity.ok(attendances);
    }

    @PostMapping("/mark")
    public ResponseEntity<Void> createAttendance(@RequestBody AttendanceDTO attendanceDTO) {
        attendanceService.saveAttendance(
                attendanceDTO.studentId(),
                attendanceDTO.classId(),
                attendanceDTO.date(),
                attendanceDTO.present(),
                attendanceDTO.lateArrival(),
                attendanceDTO.earlyDeparture()

        );
        return ResponseEntity.ok().build();
    }
}