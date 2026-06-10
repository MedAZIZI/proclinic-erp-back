package com.proclinic.erp.settings.service;

import com.proclinic.erp.settings.service.dto.ServiceRequest;
import com.proclinic.erp.settings.service.dto.ServiceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceServiceImpl implements ServiceService {

    private final ServiceRepository serviceRepository;

    @Override
    public List<ServiceResponse> getAll() {
        return serviceRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public ServiceResponse getById(Long id) {

        ClinicService service = serviceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Service not found"));

        return mapToResponse(service);
    }

    @Override
    public ServiceResponse create(ServiceRequest request) {

        ClinicService service = ClinicService.builder()
                .name(request.getName())
                .description(request.getDescription())
                .status(request.getStatus())
                .build();

        ClinicService saved = serviceRepository.save(service);

        return mapToResponse(saved);
    }

    @Override
    public ServiceResponse update(Long id, ServiceRequest request) {

        ClinicService service = serviceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Service not found"));

        service.setName(request.getName());
        service.setDescription(request.getDescription());
        service.setStatus(request.getStatus());

        ClinicService updated = serviceRepository.save(service);

        return mapToResponse(updated);
    }

    @Override
    public void delete(Long id) {
        serviceRepository.deleteById(id);
    }

    private ServiceResponse mapToResponse(ClinicService service) {

        return ServiceResponse.builder()
                .id(service.getId())
                .name(service.getName())
                .description(service.getDescription())
                .status(service.getStatus())
                .build();
    }
}