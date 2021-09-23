package com.hackathon.amazoneclone.user.dto;

import com.hackathon.amazoneclone.user.AuthProvider;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

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
    private String email;

    @NotNull
    private AuthProvider authProvider;
    private String password;


    public boolean valid(){
        if( authProvider == AuthProvider.EMAIL){
            return  password!= null && !password.equals("") && password.length()>= 8;
        }
        return  false;
    }
}
