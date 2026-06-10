package com.proclinic.erp.patient.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class PatientResponse {

    private Long id;

    private String patientCode;

    private String firstName;
    private String lastName;
    private String cin;
    private String sex;

    private String phone;
    private String email;

    private String status;
    private String address;
    
    // 🔥 display names (front-friendly)
    private String cityName;
    private String professionName;
    private LocalDate dateOfBirth;

    // insurance data :
    private InsuranceInfoResponse insurance;


    // medicalRecord
    private MedicalRecordResponse medicalRecord;

}