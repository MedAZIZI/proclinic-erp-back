package com.proclinic.erp.settings.insurance.service;

import com.proclinic.erp.settings.insurance.entity.Insurance;

import java.util.List;

public interface InsuranceService {

    List<Insurance> getAll();

    Insurance getById(Long id);

    Insurance create(Insurance insurance);

    Insurance update(Long id, Insurance insurance);

    void delete(Long id);
}