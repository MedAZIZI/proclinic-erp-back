package com.proclinic.erp.patient.entity.sub;

import com.proclinic.erp.patient.entity.Patient;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "medical_records")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MedicalRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 🔥 business code
    @Column(unique = true, nullable = false)
    private String medicalRecordCode;

    // 🧠 medical info
    @Column(columnDefinition = "TEXT")
    private String medicalHistory;

    @Column(columnDefinition = "TEXT")
    private String allergies;

    private String bloodGroup;

    @Column(columnDefinition = "TEXT")
    private String notes;

    // 🔗 relation patient (1–1)
    @OneToOne
    @JoinColumn(name = "patient_id", unique = true)
    private Patient patient;

    // 📅 timestamps
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