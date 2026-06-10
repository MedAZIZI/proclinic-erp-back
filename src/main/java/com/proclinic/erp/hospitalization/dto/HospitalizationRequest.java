package com.proclinic.erp.hospitalization.dto;

import com.proclinic.erp.hospitalization.enums.HospitalizationStatus;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class HospitalizationRequest {

    private Long patientId;

    private LocalDate admissionDate;
    private LocalDate dischargeDate;

    private String roomNumber;

    private HospitalizationStatus status;

    private Integer intensiveCareDays;
    private Integer reanimationDays;
    private Integer incubatorDays;

    private String observations;
    private String treatingDoctor;

    private List<HospitalizationActDto> acts;

    private Double additionalAmount;
}
