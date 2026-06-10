package com.proclinic.erp.patient.repository;

import com.proclinic.erp.patient.entity.sub.MedicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MedicalRecordRepository extends JpaRepository<MedicalRecord, Long> {

    // 🔎 retrouver un dossier par patient
    Optional<MedicalRecord> findByPatientId(Long patientId);

    // 🔎 retrouver par code dossier médical (MED-1001)
    Optional<MedicalRecord> findByMedicalRecordCode(String medicalRecordCode);
}