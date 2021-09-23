package com.hackathon.amazoneclone.user.dto;

import com.hackathon.amazoneclone.user.Sex;
import com.hackathon.amazoneclone.user.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.time.LocalDate;

/**
 * @author danyls ngongang
 * @Created 12/09/2021-09:36
 * @Project user-service
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterRequest {

    @Size(min = 5, max = 50 , message = "The firstname length most be between 5 and 50 character")
    @NotNull
    private String firstName;

    @Size(min = 5, max = 50 , message = "The lastname length most be between 5 and 50 character")
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

    @Size(min = 8, message = "Password most have at least 8 characters")
    @NotNull
    private String password;

}
