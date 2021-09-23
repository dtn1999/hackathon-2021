package com.hackathon.amazoneclone.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackathon.amazoneclone.security.JWTUtils;
import com.hackathon.amazoneclone.user.dto.AuthResponse;
import com.hackathon.amazoneclone.user.dto.RegisterRequest;
import com.hackathon.amazoneclone.utils.ApiResponse;
import lombok.SneakyThrows;
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

import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author danyls ngongang
 * @Created 20/09/2021-07:29
 * @Project user-service
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @MockBean
    private UserController userController;

    @MockBean
    private UserService userService;

    @Autowired
    private LoginDetailRepository loginDetailRepository;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private JWTUtils jwtUtils;

    @SneakyThrows
    @Test
    void register() {
        RegisterRequest request = RegisterRequest.builder()
                .birthday(LocalDate.of(1999, 1, 17))
                .email("test@email.com")
                .lastName("testLastName")
                .firstName("testFirstName")
                .role(UserRole.PASSENGER)
                .sex(Sex.M)
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

    @Test
    void login() {
    }
}
