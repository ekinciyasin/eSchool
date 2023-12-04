package com.ekinci.eSchool.service;

import com.ekinci.eSchool.model.Student;
import com.ekinci.eSchool.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    public StudentRepository studentRepository;


    public Student createStudent(Student student) {
        Student savedStudent = studentRepository.save(student);
        return savedStudent;
    }
    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
    }
    public List<Student> getStudentsByKeyword(String keyword) {
        return studentRepository.searchStudents(keyword);

    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    public Student updateStudent(Long id, Student updatedStudent) {
        Student existingStudent = getStudentById(id);

//        Optional.of(updatedStudent.getUser().getFirstName()).ifPresent(existingStudent.getUser()::setFirstName);
//        Optional.of(updatedStudent.getUser().getLastName()).ifPresent(existingStudent.getUser()::setLastName);
//        Optional.of(updatedStudent.getEmail()).ifPresent(existingStudent::setEmail);
//        Optional.of(updatedStudent.getAddress()).ifPresent(existingStudent::setAddress);
//        Optional.of(updatedStudent.getContactNumber()).ifPresent(existingStudent::setContactNumber);
//        Optional.of(updatedStudent.getDateOfBirth()).ifPresent(existingStudent::setDateOfBirth);


        return studentRepository.save(existingStudent);
    }
}
