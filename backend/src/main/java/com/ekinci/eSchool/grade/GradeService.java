package com.ekinci.eSchool.grade;

import com.ekinci.eSchool.dto.GradeView.GradeViewForStudent;
import com.ekinci.eSchool.model.model.Exam;
import com.ekinci.eSchool.model.model.Lesson;
import com.ekinci.eSchool.student.Student;
import com.ekinci.eSchool.service.LessonService;
import com.ekinci.eSchool.service.NotificationService;
import com.ekinci.eSchool.student.StudentService;
import com.ekinci.eSchool.user.UserRepository;
import com.ekinci.eSchool.user.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class GradeService {
    @Autowired
    private GradeRepository gradeRepository;

    @Autowired
    private StudentService studentService;


    private LessonService lessonService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private NotificationService notificationService;

    public List<Grade> getGradesByStudentId(Long studentId) {
        return gradeRepository.findByStudentId(studentId);
    }
    public List<GradeViewForStudent> getGradesByStudentIdWithProjection(Long studentId) {
        return gradeRepository.findByStudentIdWithProjection(studentId);
//        return null;
    }

    public Exam addGrade(Long studentId, Exam exam) {
        Student student = studentService.getStudentById(studentId);
        //exam.setStudent(student);
//        notificationService.sendGradeNotification(studentId, exam.getSubject(), exam.getScore());
        return null;
    }

    public List<GradeViewForStudent> getGradesByUsername(String authenticatedUsername) {
        User user = userRepository.findByUsername(authenticatedUsername);
        Student studentByUserId = studentService.getStudentByUserId(user.getId());
        List<Lesson> lessonsByStudentId = lessonService.getLessonsByStudent(studentByUserId);
        lessonsByStudentId.forEach(lesson -> System.out.println("Lesson Name: " + lesson.getName()));
        List<GradeViewForStudent> gradesByStudentId = getGradesByStudentIdWithProjection(studentByUserId.getId());
        return mergeGradesAndLessons(gradesByStudentId,lessonsByStudentId);

    }

    public List<GradeViewForStudent> mergeGradesAndLessons(List<GradeViewForStudent> grades, List<Lesson> lessons) {
        // Öğrencinin aldığı dersleri harita olarak sakla
        Map<Long, GradeViewForStudent> gradesMap = new HashMap<>();
        for (GradeViewForStudent grade : grades) {
            gradesMap.put(grade.getLesson().getId(), grade);
        }

        // Notları olmayan dersleri tespit et ve yeni GradeViewForStudent nesneleri oluştur
        List<GradeViewForStudent> lessonsWithoutGrade = new ArrayList<>();
        for (Lesson lesson : lessons) {
            if (!gradesMap.containsKey(lesson.getId())) {
                // Notları olmayan ders
                GradeViewForStudent lessonWithoutGrade = new GradeViewForStudent();
                lessonWithoutGrade.getLesson().setId(lesson.getId());
                lessonWithoutGrade.getLesson().setName(lesson.getName());
                lessonWithoutGrade.setGradeValue(-1);  // Not kısmına null değeri ekle
                lessonsWithoutGrade.add(lessonWithoutGrade);
            }
        }

        // Tüm GradeViewForStudent nesnelerini birleştir
        List<GradeViewForStudent> gradeViewForStudents = new ArrayList<>(grades);
        gradeViewForStudents.addAll(lessonsWithoutGrade);

        return gradeViewForStudents;
    }
}
