package com.hackathon.amazoneclone.security;

import com.hackathon.amazoneclone.user.User;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author danyls ngongang
 * @Created 20/09/2021-15:22
 * @Project user-service
 */
public class SecurityUtils {

    public static User getUserFromSecurityContext(){
        SecurityContext context = SecurityContextHolder.getContext();
        return  (User) context.getAuthentication().getPrincipal();
    }
}
