package com.proclinic.erp.settings.profession.dto;

import com.proclinic.erp.settings.profession.entity.ProfessionStatus;
import lombok.Data;

@Data
public class ProfessionRequest {

    private String name;

    private ProfessionStatus status;}