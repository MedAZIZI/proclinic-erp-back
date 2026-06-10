package com.proclinic.erp.settings.staff.controller;


import com.proclinic.erp.settings.staff.dto.StaffRequest;
import com.proclinic.erp.settings.staff.dto.StaffResponse;
import com.proclinic.erp.settings.staff.service.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/staff")
@RequiredArgsConstructor
public class StaffController {

    private final StaffService staffService;

    @GetMapping
    public List<StaffResponse> getAll() {
        return staffService.getAll();
    }

    @GetMapping("/{id}")
    public StaffResponse getById(@PathVariable Long id) {
        return staffService.getById(id);
    }

    @PostMapping
    public StaffResponse create(@RequestBody StaffRequest request) {
        return staffService.create(request);
    }

    @PutMapping("/{id}")
    public StaffResponse update(@PathVariable Long id,
                                @RequestBody StaffRequest request) {
        return staffService.update(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        staffService.delete(id);
    }
}