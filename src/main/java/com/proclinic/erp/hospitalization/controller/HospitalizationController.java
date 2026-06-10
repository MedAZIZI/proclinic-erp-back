package com.proclinic.erp.hospitalization.controller;

import com.proclinic.erp.hospitalization.dto.HospitalizationActDto;
import com.proclinic.erp.hospitalization.dto.HospitalizationRequest;
import com.proclinic.erp.hospitalization.dto.HospitalizationResponse;
import com.proclinic.erp.hospitalization.service.HospitalizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hospitalizations")
@RequiredArgsConstructor
public class HospitalizationController {

    private final HospitalizationService service;

    @PostMapping
    public HospitalizationResponse create(@RequestBody HospitalizationRequest request) {
        return service.create(request);
    }

    @GetMapping("/{id}")
    public HospitalizationResponse getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<HospitalizationResponse> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public HospitalizationResponse update(@PathVariable Long id,
                                          @RequestBody HospitalizationRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        return ResponseEntity.ok(service.delete(id));
    }
    @GetMapping("/patient/{patientId}")
    public List<HospitalizationResponse> getByPatient(@PathVariable Long patientId) {
        return service.getByPatientId(patientId);
    }

    @PostMapping("/{id}/acts")
    public HospitalizationResponse addAct(@PathVariable Long id,
                                          @RequestBody HospitalizationActDto request) {
        return service.addAct(id, request);
    }
}
