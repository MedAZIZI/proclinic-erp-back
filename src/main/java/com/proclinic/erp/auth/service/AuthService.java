package com.proclinic.erp.auth.service;

import com.proclinic.erp.auth.dto.LoginRequest;
import com.proclinic.erp.auth.dto.LoginResponse;
import com.proclinic.erp.auth.entity.User;
import com.proclinic.erp.auth.repository.UserRepository;
import com.proclinic.erp.auth.security.JwtService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository repository;
    private final PasswordEncoder encoder;
    private final JwtService jwtService;

    public AuthService(
            UserRepository repository,
            PasswordEncoder encoder,
            JwtService jwtService
    ) {
        this.repository = repository;
        this.encoder = encoder;
        this.jwtService = jwtService;
    }

    public LoginResponse login(LoginRequest request) {

        User user = repository.findByUsername(request.getUsername())
                .orElseThrow(() ->
                        new RuntimeException("User not found")
                );

        if(!encoder.matches(
                request.getPassword(),
                user.getPassword()
        )) {
            throw new RuntimeException("Invalid password");
        }

        String token =
                jwtService.generateToken(
                        user.getUsername(),
                        user.getRole().name()
                );

        return new LoginResponse(
                token,
                user.getRole().name()
        );
    }
}