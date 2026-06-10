package com.proclinic.erp.patient.service;

import com.proclinic.erp.patient.dto.MedicalRecordResponse;
import com.proclinic.erp.patient.dto.PatientRequest;
import com.proclinic.erp.patient.dto.PatientResponse;

import java.util.List;

public interface PatientService {

    // 📌 GET ALL
    List<PatientResponse> getAll();

    // 📌 GET BY ID
    PatientResponse getById(Long id);

    // 📌 CREATE PATIENT + AUTO MEDICAL RECORD
    PatientResponse create(PatientRequest request);

    // 📌 UPDATE PATIENT
    PatientResponse update(Long id, PatientRequest request);

    //    MedicalRecordResponse getByPatientId(Long patientId);
    // 📌 DELETE PATIENT
    void delete(Long id);
}