package com.proclinic.erp.settings.city;

import com.proclinic.erp.settings.city.dto.CityResponse;
import com.proclinic.erp.settings.city.dto.CreateCityRequest;

import java.util.List;

public interface CityService {

    List<CityResponse> getAll();

    CityResponse getById(Long id);

    CityResponse create(CreateCityRequest request);

    CityResponse update(Long id, CreateCityRequest request);

    void delete(Long id);
}