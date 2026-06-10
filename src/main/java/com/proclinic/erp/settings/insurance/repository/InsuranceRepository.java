package com.proclinic.erp.settings.insurance.repository;


import com.proclinic.erp.settings.insurance.entity.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InsuranceRepository extends JpaRepository<Insurance, Long> {

    // 🔎 vérifier unicité matricule
    Optional<Insurance> findByMatricule(String matricule);

    // 🔎 recherche simple par nom (utile pour front search)
    Optional<Insurance> findByName(String name);
}
