package com.example.employeePayrollMySql.EmployeePayroll_MySql_db.controller;



import com.example.employeePayrollMySql.EmployeePayroll_MySql_db.model.Employee;
import com.example.employeePayrollMySql.EmployeePayroll_MySql_db.repository.EmployeePayrollRepository;
import com.example.employeePayrollMySql.EmployeePayroll_MySql_db.service.EmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import java.util.List;

@RestController
public class EmployeePayrollController {

    @Autowired
    private EmployeePayrollService service;

    // Create Employee
    @PostMapping("/create")
    public ResponseEntity<String> createEmployee(@RequestBody Employee employee) {
        service.createEmployee(employee);
        return ResponseEntity.ok("Employee created successfully");
    }

    // Get All Employees
    @GetMapping("/all")
    public List<Employee> getAllEmployees() {
        return service.getAllEmployees();
    }

    // Get Employee by ID
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        return service.getEmployeeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Update Employee
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable Long id, @RequestBody Employee updatedEmployee) {
        return service.updateEmployee(id, updatedEmployee)
                .map(e -> ResponseEntity.ok("Employee updated successfully"))
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete Employee
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        if (service.deleteEmployee(id)) {
            return ResponseEntity.ok("Employee deleted successfully");
        }
        return ResponseEntity.notFound().build();
    }
}