package com.proclinic.erp.patient.controller;

import com.proclinic.erp.patient.dto.MedicalRecordRequest;
import com.proclinic.erp.patient.dto.MedicalRecordResponse;
import com.proclinic.erp.patient.service.MedicalRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/medical-records")
@RequiredArgsConstructor
public class MedicalRecordController {

    private final MedicalRecordService medicalRecordService;

    @PutMapping("/{patientId}")
    public MedicalRecordResponse update(
            @PathVariable Long patientId,
            @RequestBody MedicalRecordRequest request) {

        return medicalRecordService.update(patientId, request);
    }
}