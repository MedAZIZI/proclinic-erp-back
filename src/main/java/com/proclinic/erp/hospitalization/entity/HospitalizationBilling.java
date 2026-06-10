package com.proclinic.erp.hospitalization.entity;

import com.proclinic.erp.common.entity.BaseEntity;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class HospitalizationBilling {

    private Double hospitalizationAmount;
    private Double insuranceAmount;
    private Double patientAmount;
    private Double additionalAmount;
}