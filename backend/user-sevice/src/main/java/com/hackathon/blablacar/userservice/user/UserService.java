package com.hackathon.blablacar.userservice.user;

import com.hackathon.blablacar.userservice.user.dto.RegisterRequest;
import com.hackathon.blablacar.userservice.utils.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author danyls ngongang
 * @Created 10/09/2021-11:33
 * @Project user-service
 */
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final LoginDetailRepository loginDetailRepository;

    public ApiResponse registerUser(RegisterRequest request) {
        User user = User.builder()
                .lastName(request.getLastName())
                .firstName(request.getFirstName())
                .sex(request.getSex())
                .birthday(request.getBirthday())
                .role(request.getRole())
                .email(request.getEmail())
                .build();
        User savedUser = userRepository.save(user);
        LoginDetail loginDetail = LoginDetail.builder()
                .authProvider(AuthProvider.EMAIL)
                .password(request.getPassword())
                .user( savedUser )
                .build();
        LoginDetail savedLoginDetail = loginDetailRepository.save(loginDetail);
        return ApiResponse.builder()
                .success( true )
                .data( savedLoginDetail )
                .error(null)
                .build();
    }
}
