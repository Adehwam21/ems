package com.example.ems.controller;

import java.net.http.HttpResponse;
import java.util.List;

import com.example.ems.model.Employee;
import com.example.ems.request.AddEmployeeRequest;
import com.example.ems.request.UpdateEmployeeRequest;
import com.example.ems.response.ApiResponse;
import com.example.ems.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "${api.prefix}/employees")
public class EmployeeController {
    // Constant to include the employeeService class in employee controller
    private final EmployeeService employeeService;

    // Constructor to set the attribute of the employee controller class to an
    // instance of the employeeService class, this is achieved by the annotation
    // @Autowired.
    // Dependency injection

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse> getAllEmployees(){
        List<Employee> employees =  employeeService.getAllEmployees();
        return ResponseEntity.ok(new ApiResponse(200, "Employees found!", employees));
    }

    @GetMapping(path= "/employee/{employeeId}")
    public ResponseEntity<ApiResponse> getEmployeeById(@PathVariable Long employeeId){
        try {
            Employee employee = employeeService.getEmployeeById(employeeId);
            return  ResponseEntity.ok(new ApiResponse(200, "Employee found!", employee));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ApiResponse(500, e.getMessage(), null));
        }
    }

    @PostMapping(path= "/add")
    public ResponseEntity<ApiResponse> addEmployee(@RequestBody AddEmployeeRequest employeeData){
        try {
            Employee employee = employeeService.addEmployee(employeeData);
            return ResponseEntity.ok(new ApiResponse(200, "Employee added successfully!", employee));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ApiResponse(500, e.getMessage(), null));
        }
    }

    @PutMapping(path="/employee/update/{employeeId}")
    public ResponseEntity<ApiResponse> updateEmployee(@RequestBody UpdateEmployeeRequest newEmployeeData, @PathVariable Long employeeId){
        try {
            Employee updatedEmployee = employeeService.updateEmployeeById(newEmployeeData, employeeId);
            return ResponseEntity.ok(new ApiResponse(201, "Added employee successfully", updatedEmployee));
        } catch (Exception e) {
            return ResponseEntity.status(201).body(new ApiResponse(201, e.getMessage(), null));
        }

    }

    @DeleteMapping(path="/employee/delete/{employeeId}")
    public ResponseEntity<ApiResponse> deleteEmployee(@PathVariable Long employeeId){
        try {
            employeeService.deleteEmployeeById(employeeId);
            return ResponseEntity.ok(new ApiResponse(200, "Employee deleted successfully", null));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ApiResponse(500, e.getMessage(), null));
        }

    }

}