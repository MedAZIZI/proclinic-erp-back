package com.proclinic.erp.hospitalization.service;


import com.proclinic.erp.hospitalization.dto.HospitalizationActDto;
import com.proclinic.erp.hospitalization.dto.HospitalizationRequest;
import com.proclinic.erp.hospitalization.dto.HospitalizationResponse;

import java.util.List;

public interface HospitalizationService {

    HospitalizationResponse create(HospitalizationRequest request);

    HospitalizationResponse getById(Long id);

    List<HospitalizationResponse> getAll();

    HospitalizationResponse update(Long id, HospitalizationRequest request);

    String delete(Long id);

    List<HospitalizationResponse> getByPatientId(Long patientId);

    HospitalizationResponse addAct(Long hospitalizationId,
                                   HospitalizationActDto request);
}