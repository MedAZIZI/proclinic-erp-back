package com.proclinic.erp.hospitalization.repository;


import com.proclinic.erp.hospitalization.entity.Hospitalization;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface HospitalizationRepository extends JpaRepository<Hospitalization, Long> {

    // 🔍 récupérer par patient
    List<Hospitalization> findByPatientId(Long patientId);

    // 🔍 récupérer hospitalisation active d’un patient
    Optional<Hospitalization> findByPatientIdAndStatus(Long patientId, String status);

    // 🔍 filtrer par statut
    List<Hospitalization> findByStatus(String status);
}