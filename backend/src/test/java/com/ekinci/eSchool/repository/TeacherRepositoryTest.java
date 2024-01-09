package com.ekinci.eSchool.repository;

import com.ekinci.eSchool.dto.TeacherInfoDTO;
import com.ekinci.eSchool.model.Role;
import com.ekinci.eSchool.model.Teacher;
import com.ekinci.eSchool.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import java.util.Set;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindTeachersByKeyword() {
        // Test verisi oluştur
        User user = new User();
        user.setId(5L);
        user.setUsername("teacher5");
        user.setFirstName("Murat");
        user.setLastName("Ozturk");
        user.setPassword("password");
        user.setAuthorities(Set.of(Role.ROLE_TEACHER));

        // User'ı veritabanına ekleyerek yönetilmiş hale getir
        userRepository.save(user);

        Teacher teacher = new Teacher();
        // User nesnesini Teacher'a bağla
        teacher.setUser(user);

        // Kullanıcı null değilse devam et
        if (teacher.getUser() != null) {
            teacher.getUser().setUsername("teacher5");
        }

        teacherRepository.save(teacher);

        // Anahtar kelimeye göre öğretmenleri ara
        List<TeacherInfoDTO> teachers = teacherRepository.findTeachersByKeyword("Math");

        // Sonuçları kontrol et
        assertEquals(1, teachers.size());
        TeacherInfoDTO foundTeacher = teachers.get(0);
        assertEquals("teacher2", foundTeacher.getUsername());
        assertEquals("Murat", foundTeacher.getFirstName());
        assertEquals("Ozturk", foundTeacher.getLastName());

    }
}
