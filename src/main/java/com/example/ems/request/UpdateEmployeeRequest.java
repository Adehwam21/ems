package com.example.ems.request;

import lombok.Data;

@Data
public class UpdateEmployeeRequest {
    private Long employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private String title;
}
