package com.ekinci.eSchool.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public record SchoolClassDTO(Long teacherId, String className, String classCode, String classDescription) {
}
