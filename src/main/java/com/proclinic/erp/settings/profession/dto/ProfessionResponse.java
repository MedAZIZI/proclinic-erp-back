package com.proclinic.erp.settings.profession.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProfessionResponse {
    private Long id;
    private String name;
    private String status;
}