package com.proclinic.erp.auth.controller;

import com.proclinic.erp.auth.dto.LoginRequest;
import com.proclinic.erp.auth.dto.LoginResponse;
import com.proclinic.erp.auth.service.AuthService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public LoginResponse login(
            @RequestBody LoginRequest request
    ) {
        return authService.login(request);
    }
//    @Bean
//    CommandLineRunner run(PasswordEncoder encoder) {
//        return args -> {
//            System.out.println(encoder.encode("admin123"));
//        };
//    }
}