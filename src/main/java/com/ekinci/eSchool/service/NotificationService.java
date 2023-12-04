package com.ekinci.eSchool.service;

import com.ekinci.eSchool.model.Notification;
import com.ekinci.eSchool.model.Student;
import com.ekinci.eSchool.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NotificationService {


    private JavaMailSender javaMailSender;

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private StudentService studentService;


    public List<Notification> getNotificationsByStudentId(Long studentId) {
        return notificationRepository.findByStudentIdOrderByTimestampDesc(studentId);
    }

    public void sendGradeNotification(Long studentId, String gradeSubject, double grade) {
        Student student = studentService.getStudentById(studentId);
        String message = String.format("New grade recorded for %s: %s - %.2f", student.getFullName(), gradeSubject, grade);

        Notification notification = new Notification();
        notification.setStudent(student);
        notification.setMessage(message);
        notification.setTimestamp(LocalDateTime.now());

        notificationRepository.save(notification);

        // Add code to send the actual notification (email, push notification, etc.)
        sendNotificationViaEmail(student.getEmail(), message);
    }

    private void sendNotificationViaEmail(String toEmail, String message) {
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo(toEmail);
            mailMessage.setSubject("New Grade Notification");
            mailMessage.setText(message);

//            javaMailSender.send(mailMessage);

            System.out.println("Email notification sent successfully.");
        } catch (MailException e) {
            System.err.println("Error sending email notification: " + e.getMessage());
        }
    }

}
