package com.proclinic.erp.settings.service.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ServiceResponse {

    private Long id;
    private String name;
    private String description;
    private String status;
}