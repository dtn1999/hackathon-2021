package com.hackathon.amazoneclone.user;

import com.hackathon.amazoneclone.user.dto.AuthResponse;
import com.hackathon.amazoneclone.user.dto.LoginRequest;
import com.hackathon.amazoneclone.user.dto.RegisterRequest;
import com.hackathon.amazoneclone.utils.APIResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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

    @Operation( summary = "Register a user. With Email as auth provider")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "201", description = "User was created successfully", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = AuthResponse.class))}),
            @ApiResponse(responseCode = "400", description = "Payload of the request was not correct",content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = AuthResponse.class))}),
            @ApiResponse(responseCode = "409", description = "A user with the given email already exist in the system", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = AuthResponse.class))})
    })
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public APIResponse register(@RequestBody @Valid RegisterRequest request) {
        return userService.registerUser(request);
    }

    @Operation( summary = "Login a user. With the respective auth provider")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "User login successfully", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = AuthResponse.class))}),
            @ApiResponse(responseCode = "400", description = "Payload of the request was not correct",content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = AuthResponse.class))}),
            @ApiResponse(responseCode = "404", description = "No user found with the given login credentials", content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = AuthResponse.class))})
    })
    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public APIResponse login(@RequestBody @Valid LoginRequest request){
        return userService.login(request);
    }
}
