package com.example.employeePayrollMySql.EmployeePayroll_MySql_db.service;


import com.example.employeePayrollMySql.EmployeePayroll_MySql_db.model.Employee;
import com.example.employeePayrollMySql.EmployeePayroll_MySql_db.repository.EmployeePayrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeePayrollService {
    // uc3 section2 

    private final List<Employee> employeeList = new ArrayList<>();
    private Long employeeIdCounter = 1L; // To assign unique IDs

    // Create Employee
    public Employee createEmployee(Employee employee) {
        employee.setId(employeeIdCounter++); // Manually set unique ID
        employeeList.add(employee);
        return employee;
    }

    // Get All Employees
    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    // Get Employee by ID
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeList.stream()
                .filter(employee -> employee.getId().equals(id))
                .findFirst();
    }

    // Update Employee
    public Optional<Employee> updateEmployee(Long id, Employee updatedEmployee) {
        return employeeList.stream()
                .filter(employee -> employee.getId().equals(id))
                .findFirst()
                .map(employee -> {
                    employee.setName(updatedEmployee.getName());
                    employee.setSalary(updatedEmployee.getSalary());
                    return employee;
                });
    }

    // Delete Employee
    public boolean deleteEmployee(Long id) {
        return employeeList.removeIf(employee -> employee.getId().equals(id));
    }
}