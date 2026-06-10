package com.proclinic.erp.patient.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MedicalRecordResponse {

    private String medicalRecordCode;

    private String medicalHistory;

    private String allergies;

    private String bloodGroup;
}