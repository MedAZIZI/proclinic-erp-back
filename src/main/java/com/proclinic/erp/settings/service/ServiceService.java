package com.proclinic.erp.settings.service;

import com.proclinic.erp.settings.service.dto.ServiceRequest;
import com.proclinic.erp.settings.service.dto.ServiceResponse;

import java.util.List;

public interface ServiceService {

    List<ServiceResponse> getAll();

    ServiceResponse getById(Long id);

    ServiceResponse create(ServiceRequest request);

    ServiceResponse update(Long id, ServiceRequest request);

    void delete(Long id);
}