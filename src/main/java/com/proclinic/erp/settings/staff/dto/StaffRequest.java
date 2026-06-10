package com.proclinic.erp.settings.staff.dto;

import lombok.Data;

@Data
public class StaffRequest {

    private String firstName;
    private String lastName;

    private String phone;
    private String email;

    private String specialty;

    private String status;

    private Long userId;
}