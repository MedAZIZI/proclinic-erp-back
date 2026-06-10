package com.proclinic.erp.settings.staff.service;

import com.proclinic.erp.settings.staff.dto.StaffRequest;
import com.proclinic.erp.settings.staff.dto.StaffResponse;

import java.util.List;

public interface StaffService {

    List<StaffResponse> getAll();

    StaffResponse getById(Long id);

    StaffResponse create(StaffRequest request);

    StaffResponse update(Long id, StaffRequest request);

    void delete(Long id);
}