package com.hackathon.amazoneclone.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackathon.amazoneclone.security.JWTUtils;
import com.hackathon.amazoneclone.user.dto.AuthResponse;
import com.hackathon.amazoneclone.user.dto.LoginRequest;
import com.hackathon.amazoneclone.user.dto.RegisterRequest;
import com.hackathon.amazoneclone.utils.ApiResponse;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author danyls ngongang
 * @Created 20/09/2021-07:29
 * @Project user-service
 */
@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @MockBean
    private UserService userService;


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private JWTUtils jwtUtils;

    @SneakyThrows
    @Test
    @DisplayName("register with bad payload")
    void register_bad_payload() {
        RegisterRequest request = RegisterRequest.builder()
                .email("test@email.com")
                .name("testname")
                .role(UserRole.CUSTOMER)
                .password("")
                .build();


        Mockito.when( userService.registerUser(request)).thenReturn(
                ApiResponse.builder()
                        .data(AuthResponse.builder()
                                .accessToken(jwtUtils.generateToken(request.getEmail()))
                                .expiration(jwtUtils.getExpirationDuration())
                                .build()
                        )
                        .error( null )
                        .success( true )
                        .build()

        );

        mockMvc.perform(
                MockMvcRequestBuilders
                .post("/api/auth/register")
                .content(objectMapper.writeValueAsString(request) )
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect( status().isBadRequest() );
    }
    @SneakyThrows
    @Test
    @DisplayName("register with good payload")
    void register() {
        RegisterRequest request = RegisterRequest.builder()
                .email("test@email.com")
                .name("testname")
                .role(UserRole.CUSTOMER)
                .password("testPassword")
                .build();


        Mockito.when( userService.registerUser(request)).thenReturn(
                ApiResponse.builder()
                        .data(AuthResponse.builder()
                                .accessToken(jwtUtils.generateToken(request.getEmail()))
                                .expiration(jwtUtils.getExpirationDuration())
                                .build()
                        )
                        .error( null )
                        .success( true )
                        .build()

        );

        mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/api/auth/register")
                                .content(objectMapper.writeValueAsString(request) )
                                .accept(MediaType.APPLICATION_JSON)
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect( status().isCreated() )
                .andExpect( result -> {
                    ApiResponse apiResponse = objectMapper.readValue(result.getResponse().getContentAsString(), ApiResponse.class);
                    Assertions.assertTrue( apiResponse.isSuccess() );
                    Assertions.assertNull( apiResponse.getError() );
                    Assertions.assertNotNull( apiResponse.getData() );
                });
    }
    @SneakyThrows
    @Test
    @DisplayName("Login with bad login payload")
    void login_bad() {
        LoginRequest request = LoginRequest.builder()
                .password("testPassword")
                .email("test")
                .build();

        Mockito.when( userService.login(request) )
                .thenReturn(
                        ApiResponse.builder()
                                .success( true )
                                .data( AuthResponse.builder()
                                        .accessToken(jwtUtils.generateToken(request.getEmail()))
                                        .expiration(jwtUtils.getExpirationDuration())
                                        .build())
                                .error(null)
                                .build()
                );
        mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/api/auth/login")
                        .content(objectMapper.writeValueAsString(request) )
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect( status().isBadRequest());
    }
    @SneakyThrows
    @Test
    @DisplayName("Login with good login payload")
    void login_good() {
        LoginRequest request = LoginRequest.builder()
                .password("testPassword")
                .email("test@email.com")
                .build();

        Mockito.when( userService.login(request) )
                .thenReturn(
                        ApiResponse.builder()
                                .success( true )
                                .data( AuthResponse.builder()
                                        .accessToken(jwtUtils.generateToken(request.getEmail()))
                                        .expiration(jwtUtils.getExpirationDuration())
                                        .build())
                                .error(null)
                                .build()
                );
        mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/api/auth/login")
                        .content(objectMapper.writeValueAsString(request) )
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect( status().isOk())
                .andExpect( result -> {
                    ApiResponse apiResponse = objectMapper.readValue(result.getResponse().getContentAsString(), ApiResponse.class);
                    Assertions.assertNotNull( apiResponse );
                    Assertions.assertTrue( apiResponse.isSuccess() );
                    Assertions.assertNotNull( apiResponse.getData() );
                    Assertions.assertNull( apiResponse.getError());
                });
    }
}
