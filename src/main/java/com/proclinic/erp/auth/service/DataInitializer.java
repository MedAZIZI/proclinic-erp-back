package com.proclinic.erp.auth.service;

import com.proclinic.erp.auth.entity.Role;
import com.proclinic.erp.auth.entity.User;
import com.proclinic.erp.auth.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class DataInitializer {

    private final UserRepository repository;
    private final PasswordEncoder encoder;

    public DataInitializer(
            UserRepository repository,
            PasswordEncoder encoder
    ) {
        this.repository = repository;
        this.encoder = encoder;
    }

    @PostConstruct
    public void init() {

        if(repository.findByUsername("admin").isEmpty()) {

            User admin = new User();

            admin.setUsername("admin");
            admin.setPassword(encoder.encode("admin123"));
            admin.setRole(Role.ADMIN);

            repository.save(admin);

            System.out.println("ADMIN CREATED");
        }
    }
}