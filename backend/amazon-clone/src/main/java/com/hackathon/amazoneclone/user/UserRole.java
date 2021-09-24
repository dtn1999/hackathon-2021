package com.hackathon.amazoneclone.user;

import lombok.Getter;

/**
 * @author danyls ngongang
 * @Created 10/09/2021-11:57
 * @Project user-service
 */
public enum UserRole {
    CUSTOMER("ROLE_CUSTOMER"),
    OWNER("ROLE_OWNER")
    ;
    private final String role;

    UserRole(String role) {
        this.role = role;
    }

    public String role(){
        return  role;
    }

}
