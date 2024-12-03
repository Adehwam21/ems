package com.example.ems.repository;

import com.example.ems.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findByEmail(String email);
    List<Employee> findAllByFirstName(String firstName);
    List<Employee> findAllByLastName(String lastName);
    List<Employee> findAllByTitle(String title);
}
