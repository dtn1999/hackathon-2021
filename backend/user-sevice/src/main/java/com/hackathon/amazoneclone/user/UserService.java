package com.hackathon.amazoneclone.user;

import com.hackathon.amazoneclone.security.JWTUtils;
import com.hackathon.amazoneclone.user.dto.AuthResponse;
import com.hackathon.amazoneclone.user.dto.LoginRequest;
import com.hackathon.amazoneclone.user.dto.RegisterRequest;
import com.hackathon.amazoneclone.utils.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * @author danyls ngongang
 * @Created 10/09/2021-11:33
 * @Project user-service
 */
@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final LoginDetailRepository loginDetailRepository;
    // import the jwt util to create token after successful login or registration
    private final JWTUtils jwtUtils;
    private  final PasswordEncoder passwordEncoder;

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

        loginDetailRepository.save(loginDetail);



        return ApiResponse.builder()
                .success( true )
                .data( AuthResponse.builder()
                        .accessToken( jwtUtils.generateToken( loginDetail.getUsername()))
                        .expiration( jwtUtils.getExpirationDuration() )
                        .build() )
                .error(null)
                .build();
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<LoginDetail> loginDetails = loginDetailRepository.findLoginDetailByUser_Email(email);
        return loginDetails.orElseThrow( ()-> new UsernameNotFoundException(String.format("User with email %s could not be found", email)));
    }

    public ApiResponse login(LoginRequest request) {
        Optional<LoginDetail> loginDetail = loginDetailRepository.findLoginDetailByUser_Email(request.getEmail());
        if(loginDetail.isPresent() ){
            if( request.getAuthProvider()==AuthProvider.EMAIL && passwordEncoder.matches(request.getPassword(), loginDetail.get().getPassword())){
                return ApiResponse.builder()
                        .success( true )
                        .data( AuthResponse.builder()
                                .accessToken( jwtUtils.generateToken( loginDetail.get().getUsername() ))
                                .expiration( jwtUtils.getExpirationDuration() )
                                .build() )
                        .error(null)
                        .build();
            }
        }
        throw new NoSuchElementException(String.format("No User found with the Email %s", request.getEmail()));
    }
}
