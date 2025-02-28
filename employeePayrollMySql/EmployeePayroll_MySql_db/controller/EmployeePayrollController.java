package com.example.employeePayrollMySql.EmployeePayroll_MySql_db.controller;


import com.example.employeePayrollMySql.EmployeePayroll_MySql_db.model.Employee;
import com.example.employeePayrollMySql.EmployeePayroll_MySql_db.repository.EmployeePayrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

import java.util.List;
@RestController
public class EmployeePayrollController {

    // uc1  uploading data to the database
    @Autowired
    private EmployeePayrollRepository repo;
    // post method
    @PostMapping("/create")
    public ResponseEntity<String> createEmployee(@RequestBody Employee employee) {
        repo.save(employee);
        return ResponseEntity.ok("Employee created successfully");
    }
    // Get All Employees (GET)
    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(repo.findAll());
    }

    // Get Employee by ID (GET)
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Optional<Employee> employee = repo.findById(id);
        return employee.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update Employee by id (PUT)
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable Long id, @RequestBody Employee newEmployee) {
        return repo.findById(id).map(employee -> {
            employee.setName(newEmployee.getName());
            employee.setSalary(newEmployee.getSalary());
            repo.save(employee);
            return ResponseEntity.ok("Employee updated successfully");
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Delete Employee  by id(DELETE)
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return ResponseEntity.ok("Employee deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}