package com.proclinic.erp.settings.staff.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class StaffResponse {

    private Long id;

    private String firstName;
    private String lastName;

    private String phone;
    private String email;

    private String specialty;
    private String status;

    private Long userId;

    private LocalDateTime createdAt;
}