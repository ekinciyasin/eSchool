package com.ekinci.eSchool.repository;

import com.ekinci.eSchool.dto.UserDto;
import com.ekinci.eSchool.model.Student;
import com.ekinci.eSchool.model.User;
import io.micrometer.observation.ObservationTextPublisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

@Query("SELECT new com.ekinci.eSchool.dto.UserDto(u.username, u.lastName, u.firstName,u.password) FROM User u WHERE u.username = :username")
    Optional<UserDto> findByUsername(String username);

}
