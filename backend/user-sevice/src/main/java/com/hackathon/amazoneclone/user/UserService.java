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

import javax.validation.Valid;
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
    private final JWTUtils jwtUtils;
    private  final PasswordEncoder passwordEncoder;

    public ApiResponse registerUser(@Valid RegisterRequest request) {
        User user = userRepository.save(
                User.builder()
                .password( request.getPassword())
                .name( request.getName())
                .role(request.getRole())
                .email(request.getEmail())
                .build());

    return ApiResponse.builder()
                .success( true )
                .data( AuthResponse.builder()
                        .accessToken( jwtUtils.generateToken( user.getUsername()))
                        .expiration( jwtUtils.getExpirationDuration() )
                        .build() )
                .error(null)
                .build();
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findUserByEmail(email);
        return user.orElseThrow( ()-> new UsernameNotFoundException(String.format("User with email %s could not be found", email)));
    }

    public ApiResponse login(@Valid  LoginRequest request) {
        Optional<User> user = userRepository.findUserByEmail(request.getEmail());
        if(user.isPresent() ){
            if( passwordEncoder.matches(request.getPassword(), user.get().getPassword())){
                return ApiResponse.builder()
                        .success( true )
                        .data( AuthResponse.builder()
                                .accessToken( jwtUtils.generateToken( user.get().getUsername() ))
                                .expiration( jwtUtils.getExpirationDuration() )
                                .build() )
                        .error(null)
                        .build();
            }
        }
        throw new NoSuchElementException(String.format("No User found with the Email %s", request.getEmail()));
    }
}