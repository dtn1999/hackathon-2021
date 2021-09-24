package com.hackathon.amazoneclone.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author danyls ngongang
 * @Created 20/09/2021-06:49
 * @Project user-service
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthResponse {
    private String accessToken;
    private Long expiration;
    private String username;
    private String userEmail;
}
