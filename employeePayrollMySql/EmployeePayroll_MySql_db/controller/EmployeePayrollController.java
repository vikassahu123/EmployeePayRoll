package com.example.employeePayrollMySql.EmployeePayroll_MySql_db.controller;



import com.example.employeePayrollMySql.EmployeePayroll_MySql_db.model.Employee;
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
        service.createEmployee(employee.getName(), employee.getSalary());
        return ResponseEntity.ok("Employee is created successfully");
    }

    // Get Employee by ID
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Employee>> getEmployeeById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getEmployeeById(id));
    }

    // Get All Employees
    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(service.getAllEmployees());
    }

    // Update Employee
    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        Employee updatedEmployee = service.updateEmployee(id, employee.getName(), employee.getSalary());
        return ResponseEntity.ok(updatedEmployee);
    }

    // Delete Employee
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        service.deleteEmployee(id);
        return ResponseEntity.ok("Employee deleted successfully");
    }
}