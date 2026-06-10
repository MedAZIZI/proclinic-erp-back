package com.proclinic.erp.patient.service;

import com.proclinic.erp.patient.dto.MedicalRecordRequest;
import com.proclinic.erp.patient.dto.MedicalRecordResponse;
import com.proclinic.erp.patient.entity.Patient;
import com.proclinic.erp.patient.entity.sub.MedicalRecord;
import com.proclinic.erp.patient.repository.MedicalRecordRepository;
import com.proclinic.erp.patient.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MedicalRecordServiceImpl implements MedicalRecordService {

    private final MedicalRecordRepository medicalRecordRepository;
    private final PatientRepository patientRepository;

    // 🔥 GET BY PATIENT
    @Override
    public MedicalRecordResponse getByPatientId(Long patientId) {

        MedicalRecord record = medicalRecordRepository.findByPatientId(patientId)
                .orElseThrow(() -> new RuntimeException("Medical record not found"));

        return mapToResponse(record);
    }

    // 🔥 CREATE (si besoin plus tard)
//    @Override
//    public MedicalRecordResponse create(MedicalRecordRequest request) {
//
//        Patient patient = patientRepository.findById(request.getPatientId())
//                .orElseThrow(() -> new RuntimeException("Patient not found"));
//
//        MedicalRecord record = MedicalRecord.builder()
////                .medicalRecordCode(CodeGenerator.generate("MED")) // ✔ FIX ICI
//                .medicalHistory(request.getMedicalHistory())
//                .allergies(request.getAllergies())
//                .bloodGroup(request.getBloodGroup())
//                .notes(request.getNotes())
//                .patient(patient)
//                .build();
//
//        MedicalRecord saved = medicalRecordRepository.save(record);
//
//        return mapToResponse(saved);
//    }

    // 🔥 UPDATE BY PATIENT
    @Override
    public MedicalRecordResponse update(Long patientId,
                                        MedicalRecordRequest request) {

        MedicalRecord record = medicalRecordRepository
                .findByPatientId(patientId)
                .orElseThrow(() -> new RuntimeException("Medical record not found"));

        record.setMedicalHistory(request.getMedicalHistory());
        record.setAllergies(request.getAllergies());
        record.setBloodGroup(request.getBloodGroup());
        record.setNotes(request.getNotes());

        MedicalRecord updated = medicalRecordRepository.save(record);

        return mapToResponse(updated);
    }

    // 🔥 MAPPER UNIQUE
    private MedicalRecordResponse mapToResponse(MedicalRecord record) {

        return MedicalRecordResponse.builder()
                .medicalRecordCode(record.getMedicalRecordCode())
                .medicalHistory(record.getMedicalHistory())
                .allergies(record.getAllergies())
                .bloodGroup(record.getBloodGroup())
                //.notes(record.getNotes())
                .build();
    }
}