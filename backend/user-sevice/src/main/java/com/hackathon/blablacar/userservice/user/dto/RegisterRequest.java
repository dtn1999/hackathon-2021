package com.hackathon.blablacar.userservice.user.dto;

import com.hackathon.blablacar.userservice.user.AuthProvider;
import com.hackathon.blablacar.userservice.user.Sex;
import com.hackathon.blablacar.userservice.user.UserRole;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.*;
import java.time.LocalDate;

/**
 * @author danyls ngongang
 * @Created 12/09/2021-09:36
 * @Project user-service
 */
@Data
public class RegisterRequest {

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @Email
    @NotNull
    private String email;

    @Past
    @NotNull
    private LocalDate birthday;


    private UserRole role = UserRole.PASSENGER;

    private Sex sex;

    @NotNull
    private String password;

}
