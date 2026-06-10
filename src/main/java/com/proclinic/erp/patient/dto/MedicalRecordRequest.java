package com.proclinic.erp.patient.dto;

import lombok.Data;

@Data
public class MedicalRecordRequest {

//    private Long patientId;

    private String medicalHistory;

    private String allergies;

    private String bloodGroup;

    private String notes;
}