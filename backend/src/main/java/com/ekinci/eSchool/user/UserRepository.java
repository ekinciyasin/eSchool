package com.ekinci.eSchool.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

@Query("SELECT new com.ekinci.eSchool.user.UserDto(u.username, u.lastName, u.firstName,u.email, u.password,u.roles) FROM User u WHERE u.username = :username")
    Optional<UserDto> findByUsernameWithQuery(String username);

  User findByUsername(String username);
}
