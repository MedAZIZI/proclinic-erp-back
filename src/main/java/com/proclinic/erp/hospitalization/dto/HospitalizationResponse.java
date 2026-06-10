package com.proclinic.erp.hospitalization.dto;

import com.proclinic.erp.hospitalization.entity.HospitalizationAct;
import com.proclinic.erp.hospitalization.entity.HospitalizationBilling;
import com.proclinic.erp.hospitalization.enums.HospitalizationStatus;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
public class HospitalizationResponse {

    private Long id;

    private Long patientId;

    private String patientName;

    private LocalDate admissionDate;
    private LocalDate dischargeDate;

    private String roomNumber;

    private HospitalizationStatus status;

    private Integer intensiveCareDays;
    private Integer reanimationDays;
    private Integer incubatorDays;

    private String observations;
    private String treatingDoctor;
    private String insurance;

    private List<HospitalizationAct> acts;

    private HospitalizationBilling billing;
}