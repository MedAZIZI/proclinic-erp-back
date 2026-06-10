package com.proclinic.erp.patient.controller;

import com.proclinic.erp.patient.dto.MedicalRecordResponse;
import com.proclinic.erp.patient.dto.PatientRequest;
import com.proclinic.erp.patient.dto.PatientResponse;
import com.proclinic.erp.patient.service.MedicalRecordService;
import com.proclinic.erp.patient.service.PatientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;
    private final MedicalRecordService medicalRecordService;
    // 📌 GET ALL
    @GetMapping
    public ResponseEntity<List<PatientResponse>> getAll() {
        return ResponseEntity.ok(patientService.getAll());
    }

    // 📌 GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<PatientResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(patientService.getById(id));
    }

    // 📌 CREATE
    @PostMapping
    public PatientResponse create(@Valid @RequestBody PatientRequest request) {
        return patientService.create(request);
    }

    // 📌 UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<PatientResponse> update(
            @PathVariable Long id,
            @RequestBody PatientRequest request
    ) {
        return ResponseEntity.ok(patientService.update(id, request));
    }

    // 📌 DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        patientService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/medical-record")
    public MedicalRecordResponse getMedicalRecord(@PathVariable Long id) {
        return medicalRecordService.getByPatientId(id);
    }

}