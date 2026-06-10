package com.proclinic.erp.hospitalization.entity;

import com.proclinic.erp.common.entity.BaseEntity;
import com.proclinic.erp.hospitalization.enums.HospitalizationStatus;
import com.proclinic.erp.patient.entity.Patient;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Hospitalization extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String hospitalizationCode; // HOSP-2026-001

    private LocalDate admissionDate;
    private LocalDate dischargeDate;

    private String roomNumber;

    @Enumerated(EnumType.STRING)
    private HospitalizationStatus status;

    private Integer intensiveCareDays;
    private Integer reanimationDays;
    private Integer incubatorDays;

    @Column(columnDefinition = "TEXT")
    private String observations;

    private String treatingDoctor;

    private String insurance;

    private String patientName;

    @ManyToOne
    private Patient patient;

    @Builder.Default
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HospitalizationAct> acts = new ArrayList<>();

    @Embedded
    private HospitalizationBilling billing;
}