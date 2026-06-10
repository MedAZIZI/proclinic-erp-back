package com.proclinic.erp.settings.insurance.controller;

import com.proclinic.erp.settings.insurance.entity.Insurance;
import com.proclinic.erp.settings.insurance.service.InsuranceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/insurances")
@RequiredArgsConstructor
public class InsuranceController {

    private final InsuranceService insuranceService;

    // 📌 GET ALL
    @GetMapping
    public ResponseEntity<List<Insurance>> getAll() {
        return ResponseEntity.ok(insuranceService.getAll());
    }

    // 📌 GET BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Insurance> getById(@PathVariable Long id) {
        return ResponseEntity.ok(insuranceService.getById(id));
    }

    // 📌 CREATE
    @PostMapping
    public ResponseEntity<Insurance> create(@RequestBody Insurance insurance) {
        return ResponseEntity.ok(insuranceService.create(insurance));
    }

    // 📌 UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Insurance> update(
            @PathVariable Long id,
            @RequestBody Insurance insurance
    ) {
        return ResponseEntity.ok(insuranceService.update(id, insurance));
    }

    // 📌 DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        insuranceService.delete(id);
        return ResponseEntity.noContent().build();
    }
}