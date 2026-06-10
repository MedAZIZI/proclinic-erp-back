package com.proclinic.erp.settings.profession.repository;

import com.proclinic.erp.settings.profession.entity.Profession;
import com.proclinic.erp.settings.profession.entity.ProfessionStatus;
import org.hibernate.query.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.List;

public interface ProfessionRepository extends JpaRepository<Profession, Long> {

    boolean existsByName(String name);
    List<Profession> findByNameContainingIgnoreCase(String name);
    List<Profession> findByStatus(ProfessionStatus status);
}