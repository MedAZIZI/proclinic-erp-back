package com.proclinic.erp.settings.profession.service;

import com.proclinic.erp.settings.profession.dto.ProfessionRequest;
import com.proclinic.erp.settings.profession.dto.ProfessionResponse;

import java.util.List;

public interface ProfessionService {

    List<ProfessionResponse> getAll();

    ProfessionResponse getById(Long id);

    ProfessionResponse create(ProfessionRequest request);

    ProfessionResponse update(Long id, ProfessionRequest request);

    void delete(Long id);
}