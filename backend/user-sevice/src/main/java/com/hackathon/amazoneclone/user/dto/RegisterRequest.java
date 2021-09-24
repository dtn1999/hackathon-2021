package com.hackathon.amazoneclone.user.dto;

import com.hackathon.amazoneclone.user.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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

    @Email
    @NotNull
    private String email;

    @NotNull
    @Size(min = 3, max = 100)
    private String name;


    private UserRole role = UserRole.CUSTOMER;

    @Size(min = 6, message = "Password most have at least 6 characters")
    @NotNull
    private String password;

}
