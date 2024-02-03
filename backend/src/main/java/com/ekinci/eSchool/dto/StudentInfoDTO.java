package com.ekinci.eSchool.dto;

import com.ekinci.eSchool.model.model.Gender;
import com.ekinci.eSchool.user.UserDto;
import lombok.Data;

import java.time.LocalDate;

@Data
public class StudentInfoDTO extends UserDto {

//    @OneToOne
//    private UserDTO userDTO;
//

    public StudentInfoDTO() {

    }

//    public StudentInfoDTO(String username, String lastName, String firstName, LocalDate dateOfBirth, Gender gender, String email, String contactNumber, String address) {
//        this.userDTO.setUsername(username);
//        this.userDTO.setLastName(lastName);
//        this.userDTO.setFirstName(firstName);
//        this.dateOfBirth = dateOfBirth;
//        this.gender = gender;
//        this.email = email;
//        this.contactNumber = contactNumber;
//        this.address = address;
//    }

        public StudentInfoDTO(String username, String lastName, String firstName, LocalDate dateOfBirth, Gender gender, String email, String contactNumber, String address) {
        super(username, lastName, firstName,email);
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.contactNumber = contactNumber;
        this.address = address;
    }

    private LocalDate dateOfBirth;
    private Gender gender;

    private String contactNumber;

    private String address;

}
