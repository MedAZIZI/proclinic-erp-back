package com.proclinic.erp.patient.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PatientRequest {

    @NotBlank(message = "First name is required")
    @Size(min = 2, max = 50)
    private String firstName;

    @NotBlank(message = "Last name is required")
    private String lastName;

    @NotBlank(message = "Sex is required")
    private String sex;

    @NotNull(message = "Date of birth is required")
    private LocalDate dateOfBirth;

    @NotBlank(message = "Phone is required")
    @Pattern(regexp = "^[0-9]{10,15}$")
    private String phone;

    @Email(message = "Email must be valid")
    private String email;
    private String cin;

    private String address;

    // 🔗 relations
    @NotNull(message = "City is required")
    private Long cityId;

    @NotNull(message = "Profession is required")
    private Long professionId;

    private Long insuranceId; // optionnel
}