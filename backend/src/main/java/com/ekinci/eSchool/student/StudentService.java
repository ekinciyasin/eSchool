package com.ekinci.eSchool.student;

import com.ekinci.eSchool.dto.StudentInfoDTO;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private StudentRepository studentRepository;
    private BCryptPasswordEncoder passwordEncoder;

    public StudentService(StudentRepository studentRepository, BCryptPasswordEncoder passwordEncoder) {
        this.studentRepository = studentRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public Student createStudent(Student student) {
        String encodedPassword = passwordEncoder.encode(student.getUser().getPassword());
        student.getUser().setPassword(encodedPassword);
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

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public List<StudentInfoDTO> getStudentsInfoByKeyword(String keyword) {
        return studentRepository.findStudentsInfoByKeyword(keyword);
    }

    public Student getStudentByUserId(Long userId) {
        return studentRepository.findByUserId(userId);
    }
}
