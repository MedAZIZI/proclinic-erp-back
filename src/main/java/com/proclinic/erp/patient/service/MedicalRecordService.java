package com.proclinic.erp.patient.service;

import com.proclinic.erp.patient.dto.MedicalRecordRequest;
import com.proclinic.erp.patient.dto.MedicalRecordResponse;

public interface MedicalRecordService {
    MedicalRecordResponse getByPatientId(Long patientId);
//    MedicalRecordResponse create(MedicalRecordRequest request);
    MedicalRecordResponse update(Long patientId, MedicalRecordRequest request);
}
