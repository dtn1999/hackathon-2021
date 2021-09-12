package com.hackathon.blablacar.userservice.user;

import com.hackathon.blablacar.userservice.user.dto.RegisterRequest;
import com.hackathon.blablacar.userservice.utils.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author danyls ngongang
 * @Created 10/09/2021-11:33
 * @Project user-service
 */
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Validated RegisterRequest request) {
        return new ResponseEntity(userService.registerUser(request), HttpStatus.CREATED);
    }

    public ResponseEntity login() {
        return null;
    }
}
