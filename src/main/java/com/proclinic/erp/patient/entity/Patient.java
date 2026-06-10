package com.proclinic.erp.patient.entity;

import com.proclinic.erp.settings.city.City;
import com.proclinic.erp.settings.insurance.entity.Insurance;
import com.proclinic.erp.settings.profession.entity.Profession;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "patients")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 🔥 business code
    @Column(name = "patient_code", unique = true, nullable = false)
    private String patientCode;

    private String firstName;
    private String lastName;

    private String sex;

    private LocalDate dateOfBirth;

    private String phone;
    private String email;

    @Column(unique = true)
    private String cin;
    // 🔗 SETTINGS RELATIONS
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    private String address;
    
    @ManyToOne
    @JoinColumn(name = "profession_id")
    private Profession profession;

    @ManyToOne
    @JoinColumn(name = "insurance_id")
    private Insurance insurance;

    // 🔥 STATUS
    @Enumerated(EnumType.STRING)
    private PatientStatus status;

    // 🔥 DATES
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = LocalDateTime.now();
    }
}