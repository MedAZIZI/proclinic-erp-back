package com.proclinic.erp.hospitalization.entity;

import com.proclinic.erp.common.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
@Data
public class HospitalizationAct extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String actName;
    private String amoCode;

    private Double quotation;
    private Integer quantity;

    private Double total;
}