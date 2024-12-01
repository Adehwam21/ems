package com.example.demo.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1")
public class EmployeeController {
    // Constant to include the employeeService class in employee controller
    private final EmployeeService employeeService;

    // Constructor to set the attribute of the employee controller class to an
    // instance of the employeeService class, this is achieved by the annotation
    // @Autowired.
    // Dependancy injection

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

}
