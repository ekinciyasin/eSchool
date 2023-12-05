package com.ekinci.eSchool.model.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public record SchoolClassDTO(Long teacherId, String className, String classCode, String classDescription) {
}
