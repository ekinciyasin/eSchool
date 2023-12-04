package com.ekinci.eSchool.service;

import com.ekinci.eSchool.model.Student;
import com.ekinci.eSchool.model.Teacher;
import com.ekinci.eSchool.repository.StudentRepository;
import com.ekinci.eSchool.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public Teacher getTeacherById(Long teacherId) {
        return teacherRepository.findById(teacherId)
                .orElseThrow(() -> new RuntimeException("Teacher not found with id: " + teacherId));
    }

    public Teacher createTeacher(Teacher teacher) {
        // Perform any necessary validation or business logic before saving
        return teacherRepository.save(teacher);
    }

    public Teacher updateTeacher(Long teacherId, Teacher updatedTeacher) {
        Teacher existingTeacher = getTeacherById(teacherId);

        // Update fields based on your requirements
        existingTeacher.getUser().setFirstName(updatedTeacher.getUser().getFirstName());
        existingTeacher.getUser().setLastName(updatedTeacher.getUser().getLastName());
        existingTeacher.setSubjectTaught(updatedTeacher.getSubjectTaught());
        // Update other fields...

        // Perform any necessary validation or business logic before saving
        return teacherRepository.save(existingTeacher);
    }

    public void deleteTeacher(Long teacherId) {
        teacherRepository.deleteById(teacherId);
    }
}

