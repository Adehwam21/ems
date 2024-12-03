package com.example.ems.service;

import com.example.ems.exceptions.DuplicateEmailEntryException;
import com.example.ems.exceptions.NoEmployeeFoundException;
import com.example.ems.model.Employee;
import com.example.ems.repository.EmployeeRepository;
import com.example.ems.request.AddEmployeeRequest;
import com.example.ems.request.UpdateEmployeeRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService implements IEmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public Employee addEmployee(AddEmployeeRequest employeeData) {
        // Check if the email exists
        boolean emailExists = employeeRepository.findByEmail(employeeData.getEmail()) != null;
        if (emailExists) {
            throw new DuplicateEmailEntryException("Email already exists.");
        }

        Employee newEmployee = createEmployee(employeeData);
        return employeeRepository.save(newEmployee);
    }

    private Employee createEmployee(AddEmployeeRequest request) {
        return new Employee(
                request.getFirstName(),
                request.getLastName(),
                request.getEmail(),
                request.getTitle()
        );
    }

    @Override
    public Employee getEmployeeById(Long employeeId) {
        return employeeRepository.findById(employeeId)
                .orElseThrow(() -> new NoEmployeeFoundException("No employee record matches this ID."));
    }

    @Override
    public Employee getEmployeeByEmail(String email) {
        return employeeRepository.findByEmail(email);
    }

    @Override
    public Employee updateEmployeeById(UpdateEmployeeRequest request, Long employeeId) {
        return employeeRepository.findById(employeeId)
                .map(existingEmployee -> createEmployeeUpdate(existingEmployee, request))
                .map(employeeRepository::save)
                .orElseThrow(() -> new NoEmployeeFoundException("Employee does not exist. Could not perform update."));
    }

    public Employee createEmployeeUpdate(Employee existingEmployee, UpdateEmployeeRequest request) {
        existingEmployee.setFirstName(request.getFirstName());
        existingEmployee.setLastName(request.getLastName());
        existingEmployee.setEmail(request.getEmail());
        existingEmployee.setTitle(request.getTitle());
        return existingEmployee;
    }

    @Override
    public void deleteEmployeeById(Long employeeId) {
        employeeRepository.findById(employeeId)
                .ifPresentOrElse(employeeRepository::delete,
                        () -> {
                            throw new NoEmployeeFoundException("No employee record found. Could not delete.");
                        });
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> getAllEmployeesByFirstName(String firstName) {
        return employeeRepository.findAllByFirstName(firstName);
    }

    @Override
    public List<Employee> getAllEmployeesByLastName(String lastName) {
        return employeeRepository.findAllByLastName(lastName);
    }

    @Override
    public List<Employee> getAllEmployeesByTitle(String title) {
        return employeeRepository.findAllByTitle(title);
    }
}
