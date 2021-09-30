package com.hackathon.amazoneclone.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author danyls ngongang
 * @Created 20/09/2021-06:44
 * @Project user-service
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginRequest {

    @NotNull
    @Email(message = "The email most be a valid email")
    @NotEmpty
    private String email;

    @NotNull
    @Size(min = 6, message = "Password most have at least 6 characters")
    private String password;

}
