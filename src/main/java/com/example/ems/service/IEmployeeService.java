package com.example.ems.service;

import com.example.ems.model.Employee;
import com.example.ems.request.AddEmployeeRequest;
import com.example.ems.request.UpdateEmployeeRequest;

import java.util.List;

public interface IEmployeeService {
    Employee addEmployee(AddEmployeeRequest employee);

    Employee getEmployeeById(Long employeeId);

    Employee getEmployeeByEmail(String email);

    Employee updateEmployeeById(UpdateEmployeeRequest request, Long employeeId);

    void deleteEmployeeById(Long employeeId);

    List<Employee> getAllEmployees();

    List<Employee> getAllEmployeesByFirstName(String firstName);

    List<Employee> getAllEmployeesByLastName(String lastName);

    List<Employee> getAllEmployeesByTitle(String title);
}
