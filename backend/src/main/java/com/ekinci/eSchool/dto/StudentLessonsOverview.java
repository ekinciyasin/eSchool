package com.ekinci.eSchool.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentLessonsOverview {
    private Long lessonId;
    private String lessonName;
}
