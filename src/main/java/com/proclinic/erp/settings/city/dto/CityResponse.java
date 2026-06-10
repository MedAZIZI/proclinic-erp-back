package com.proclinic.erp.settings.city.dto;

import com.proclinic.erp.settings.city.City;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
@Builder
public class CityResponse {

    private Long id;

    private String name;

    private String code;

}