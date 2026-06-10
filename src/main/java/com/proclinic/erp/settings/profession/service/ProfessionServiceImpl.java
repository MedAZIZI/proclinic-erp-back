package com.proclinic.erp.settings.profession.service;

import com.proclinic.erp.settings.profession.dto.ProfessionRequest;
import com.proclinic.erp.settings.profession.dto.ProfessionResponse;
import com.proclinic.erp.settings.profession.entity.Profession;
import com.proclinic.erp.settings.profession.repository.ProfessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfessionServiceImpl implements ProfessionService {

    private final ProfessionRepository professionRepository;

    @Override
    public List<ProfessionResponse> getAll() {
        return professionRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public ProfessionResponse getById(Long id) {

        Profession profession = professionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Profession not found"));

        return mapToResponse(profession);
    }

    @Override
    public ProfessionResponse create(ProfessionRequest request) {

        Profession profession = Profession.builder()
                .name(request.getName())
                .status(request.getStatus())
                .build();

        Profession saved = professionRepository.save(profession);

        return mapToResponse(saved);
    }

    @Override
    public ProfessionResponse update(Long id, ProfessionRequest request) {

        Profession profession = professionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Profession not found"));

        profession.setName(request.getName());
        profession.setStatus(request.getStatus());

        Profession updated = professionRepository.save(profession);

        return mapToResponse(updated);
    }

    @Override
    public void delete(Long id) {
        professionRepository.deleteById(id);
    }

    private ProfessionResponse mapToResponse(Profession profession) {
        return ProfessionResponse.builder()
                .id(profession.getId())
                .name(profession.getName())
                .status(profession.getStatus().name())
                .build();
    }
    private Profession mapProfession(Long id) {
        if (id == null) return null;

        return professionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Profession not found"));
    }
}