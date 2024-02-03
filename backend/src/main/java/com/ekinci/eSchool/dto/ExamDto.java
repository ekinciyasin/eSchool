package com.ekinci.eSchool.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
public class ExamDto {



    private Long id;


    private String name;

    private LocalDate localDate;

}
