package com.ekinci.eSchool.controller;

import com.ekinci.eSchool.model.model.SchoolClass;
import com.ekinci.eSchool.dto.SchoolClassDTO;
import com.ekinci.eSchool.service.SchoolClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/1.0/classes")
public class SchoolClassController {

    @Autowired private SchoolClassService schoolClassService;

    @GetMapping
    public ResponseEntity<List<SchoolClass>> getAllSchoolClasses(){
       List<SchoolClass>schoolClasses= schoolClassService.getSchoolClasses();
      return   ResponseEntity.ok(schoolClasses);
    }
    @PostMapping
    public ResponseEntity<SchoolClass> createSchoolClass(@RequestBody SchoolClassDTO schoolClassDTO){
        SchoolClass createdSchoolClass = schoolClassService.saveSchoolClass(
                schoolClassDTO.classCode(),
                schoolClassDTO.className(),
                schoolClassDTO.classDescription(),
                schoolClassDTO.teacherId());
        return ResponseEntity.ok(createdSchoolClass);

    }
}
