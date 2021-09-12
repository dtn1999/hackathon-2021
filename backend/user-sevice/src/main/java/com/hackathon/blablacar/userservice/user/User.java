package com.hackathon.blablacar.userservice.user;

import com.fasterxml.jackson.databind.JsonNode;
import com.hackathon.blablacar.userservice.utils.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.*;
import java.time.LocalDate;

/**
 * @author danyls ngongang
 * @Created 10/09/2021-11:31
 * @Project user-service
 */
@Entity(name = "person")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User extends BaseEntity {
//    @Max(value = 50)
//    @Min(value = 3)
    @Column(name = "person_first_name",nullable = false)
    private String firstName;

//    @Max(value = 50)
//    @Min(value = 3)
    @Column(name = "person_last_name",nullable = false)
    private String lastName;

    @Email
    @Column( name = "person_email", unique = true)
    private String email;

    @Past
    private LocalDate birthday;

    @Enumerated( EnumType.STRING)
    @Column(nullable = false)
    private  UserRole role = UserRole.PASSENGER;

    private Sex sex;
    // private JsonNode car;
}
