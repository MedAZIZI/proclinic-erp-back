package com.proclinic.erp.settings.city;

import com.proclinic.erp.settings.city.dto.CityResponse;
import com.proclinic.erp.settings.city.dto.CreateCityRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    @Override
    public List<CityResponse> getAll() {
        return cityRepository.findAll()
                .stream()
                .map(city -> CityResponse.builder()
                        .id(city.getId())
                        .name(city.getName())
                        .code(city.getCode())
                        .build())
                .toList();
    }

    @Override
    public CityResponse getById(Long id) {
        City city = cityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("City not found"));

        return CityResponse.builder()
                .id(city.getId())
                .name(city.getName())
                .code(city.getCode())
                .build();
    }

    @Override
    public CityResponse create(CreateCityRequest request) {

        City city = City.builder()
                .name(request.getName())
                .code(request.getCode())
                .build();

        City saved = cityRepository.save(city);

        return CityResponse.builder()
                .id(saved.getId())
                .name(saved.getName())
                .code(saved.getCode())
                .build();
    }

    @Override
    public CityResponse update(Long id, CreateCityRequest request) {

        City city = cityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("City not found"));

        city.setName(request.getName());
        city.setCode(request.getCode());

        City saved = cityRepository.save(city);

        return CityResponse.builder()
                .id(saved.getId())
                .name(saved.getName())
                .code(saved.getCode())
                .build();
    }

    @Override
    public void delete(Long id) {
        cityRepository.deleteById(id);
    }

    private City mapCity(Long id) {
        if (id == null) return null;

        return cityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("City not found"));
    }
}