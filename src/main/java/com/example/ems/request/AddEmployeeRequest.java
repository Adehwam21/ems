package com.example.ems.request;

import lombok.Data;

@Data
public class AddEmployeeRequest {
    private Long employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private String title;
}
