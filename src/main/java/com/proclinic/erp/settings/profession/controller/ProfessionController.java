package com.proclinic.erp.settings.profession.controller;

import com.proclinic.erp.settings.profession.dto.ProfessionRequest;
import com.proclinic.erp.settings.profession.dto.ProfessionResponse;
import com.proclinic.erp.settings.profession.service.ProfessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/professions")
@RequiredArgsConstructor
public class ProfessionController {

    private final ProfessionService service;

    @GetMapping
    public List<ProfessionResponse> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ProfessionResponse getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public ProfessionResponse create(@RequestBody ProfessionRequest request) {
        return service.create(request);
    }

    @PutMapping("/{id}")
    public ProfessionResponse update(@PathVariable Long id,
                                     @RequestBody ProfessionRequest request) {
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}