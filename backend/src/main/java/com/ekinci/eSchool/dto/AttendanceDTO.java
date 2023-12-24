package com.ekinci.eSchool.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public record AttendanceDTO(Long studentId, Long classId, LocalDate date, boolean present, LocalTime lateArrival, LocalTime earlyDeparture) {
}
