package com.ekinci.eSchool.attendance;

import com.ekinci.eSchool.dto.AttendanceDTO;
import com.ekinci.eSchool.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/1.0/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @Autowired
    private SecurityService securityService;

    @GetMapping("/my-attendance")
    public ResponseEntity<?> getAttendancesByStudent(){
        String username = null;
        try {
            username = securityService.getUsernameFromPrincipal();

            System.out.println("Kullanıcı adı: " + username);
            List<AttendanceViewForStudent> attendenceByUsername = attendanceService.getAttendancesByStudentId(username);
            return ResponseEntity.ok(attendenceByUsername);

        } catch (UsernameNotFoundException ex) {
            System.err.println("Hata: Kullanıcı adı alınamadı. " + ex.getMessage());

        }


        return ResponseEntity.ok("error");

    }


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