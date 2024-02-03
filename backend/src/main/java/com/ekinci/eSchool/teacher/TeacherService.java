package com.ekinci.eSchool.teacher;

import com.ekinci.eSchool.dto.TeacherInfoDTO;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {


    private TeacherRepository teacherRepository;
    private BCryptPasswordEncoder passwordEncoder;

    public TeacherService(TeacherRepository teacherRepository, BCryptPasswordEncoder passwordEncoder) {
        this.teacherRepository = teacherRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public Teacher getTeacherById(Long teacherId) {
        return teacherRepository.findById(teacherId)
                .orElseThrow(() -> new RuntimeException("Teacher not found with id: " + teacherId));
    }

    public Teacher createTeacher(Teacher teacher) {
        String encoded = passwordEncoder.encode(teacher.getUser().getPassword());
        teacher.getUser().setPassword(encoded);
        // Perform any necessary validation or business logic before saving
        return teacherRepository.save(teacher);
    }

    public Teacher updateTeacher(Long teacherId, Teacher updatedTeacher) {
        Teacher existingTeacher = getTeacherById(teacherId);

        // Update fields based on your requirements
        existingTeacher.getUser().setFirstName(updatedTeacher.getUser().getFirstName());
        existingTeacher.getUser().setLastName(updatedTeacher.getUser().getLastName());

        // Update other fields...

        // Perform any necessary validation or business logic before saving
        return teacherRepository.save(existingTeacher);
    }

    public void deleteTeacher(Long teacherId) {
        teacherRepository.deleteById(teacherId);
    }

    public List<Teacher> getTeachersByKeyword(String keyword) {
        return teacherRepository.searchTeachers(keyword);
    }
    public List<TeacherInfoDTO> getTeachersByKeyword2(String keyword) {
        return teacherRepository.findTeachersByKeyword(keyword);
    }
}

