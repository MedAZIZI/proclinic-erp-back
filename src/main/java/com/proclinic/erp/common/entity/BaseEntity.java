package com.proclinic.erp.common.entity;

import jakarta.persistence.MappedSuperclass;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity {

    public BaseEntity() {}

    private Boolean isDeleted = false;

    private LocalDateTime deletedAt;
}
