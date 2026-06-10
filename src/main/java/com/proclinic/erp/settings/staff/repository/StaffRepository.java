package com.proclinic.erp.settings.staff.repository;

import com.proclinic.erp.settings.staff.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<Staff, Long> {
}