// package com.example.demo.employee;

// import lombok.Data;
// import lombok.NoArgsConstructor;
// import lombok.AllArgsConstructor;

// @Data
// @NoArgsConstructor
// @AllArgsConstructor
// public class Employee {
//     private String firstName;
//     private String lastName;
//     private String email;
//     private String title;
//     private String employeeId;
// }

package com.example.ems.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    private String firstName;
    private String lastName;
    private String email;
    private String title;

    // Parameterized constructor
    public Employee(String firstName, String lastName, String email, String title) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.title = title;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + this.employeeId + '\'' +
                ", firstName='" + this.firstName + '\'' +
                ", lastName='" + this.lastName + '\'' +
                ", email='" + this.email + '\'' +
                ", title='" + this.title + '\'' +
                '}';
    }

}
