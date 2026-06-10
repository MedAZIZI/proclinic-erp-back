package com.proclinic.erp.patient.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class InsuranceInfoResponse {

    private Long id;
    private String name;
    private String matricule;
    private String type;
    private String status;
    private String  affiliation;
}
