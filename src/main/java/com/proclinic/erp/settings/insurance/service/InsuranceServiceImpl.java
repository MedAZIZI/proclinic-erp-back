package com.proclinic.erp.settings.insurance.service;

import com.proclinic.erp.settings.insurance.entity.Insurance;
import com.proclinic.erp.settings.insurance.entity.InsuranceStatus;
import com.proclinic.erp.settings.insurance.repository.InsuranceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InsuranceServiceImpl implements InsuranceService {

    private final InsuranceRepository insuranceRepository;

    @Override
    public List<Insurance> getAll() {
        return insuranceRepository.findAll();
    }

    @Override
    public Insurance getById(Long id) {
        return insuranceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Insurance not found"));
    }

    @Override
    public Insurance create(Insurance insurance) {

        // 🔒 check duplicate matricule
        insuranceRepository.findByMatricule(insurance.getMatricule())
                .ifPresent(i -> {
                    throw new RuntimeException("Matricule already exists");
                });

        return insuranceRepository.save(insurance);
    }

    @Override
    public Insurance update(Long id, Insurance request) {

        Insurance insurance = insuranceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Insurance not found"));

        insurance.setName(request.getName());
        insurance.setMatricule(request.getMatricule());
        insurance.setAffiliation(request.getAffiliation());
        insurance.setType(request.getType());
        insurance.setStatus(request.getStatus());

        return insuranceRepository.save(insurance);
    }

    @Override
    public void delete(Long id) {

        Insurance insurance = insuranceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Insurance not found"));

        insurance.setStatus(InsuranceStatus.INACTIVE);

        insuranceRepository.save(insurance);
    }
    private Insurance mapInsurance(Long id) {
        if (id == null) return null;

        return insuranceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Insurance not found"));
    }
}