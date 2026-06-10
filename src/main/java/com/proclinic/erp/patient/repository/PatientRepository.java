package com.proclinic.erp.patient.repository;

import com.proclinic.erp.patient.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    // 🔎 chercher par code patient (PAT-2026-001)
    Optional<Patient> findByPatientCode(String patientCode);

    // 🔎 éviter doublons email (optionnel mais utile)
    Optional<Patient> findByEmail(String email);

    // 🔎 chercher par téléphone
    Optional<Patient> findByPhone(String phone);
}