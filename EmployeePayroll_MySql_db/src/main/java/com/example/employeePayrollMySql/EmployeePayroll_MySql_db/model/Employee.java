package com.example.employeePayrollMySql.EmployeePayroll_MySql_db.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name="employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double salary;
    // constructor to provide data to variables in the database
    public Employee(String name, double salary){
        this.name=name;
        this.salary=salary;
    }

}