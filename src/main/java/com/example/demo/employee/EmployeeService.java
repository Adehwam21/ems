package com.example.demo.employee;

import java.util.List;
// import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

// @Service or @Component can be used

@Service
public class EmployeeService {

    public List<Employee> getAllEmployees() {
        return List.of(
                new Employee("0001", "Aaron", "Kudadjie", "aaron@email.com", "Manager"));
    }
}
