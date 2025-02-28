package com.example.employeePayrollMySql.EmployeePayroll_MySql_db.service;


import com.example.employeePayrollMySql.EmployeePayroll_MySql_db.model.Employee;
import com.example.employeePayrollMySql.EmployeePayroll_MySql_db.repository.EmployeePayrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeePayrollService {

    @Autowired
    private EmployeePayrollRepository repo;

    // Create Employee
    public Employee createEmployee(String name, double salary) {
        Employee employee = new Employee(name, salary); // No need to set manually
        return repo.save(employee);
    }

    // Get Employee by ID
    public Optional<Employee> getEmployeeById(Long id) {
        return repo.findById(id);
    }

    // Get All Employees
    public List<Employee> getAllEmployees() {
        return repo.findAll();
    }

    // Update Employee
    public Employee updateEmployee(Long id, String name, double salary) {
        Optional<Employee> existingEmployee = repo.findById(id);
        if (existingEmployee.isPresent()) {
            Employee emp = existingEmployee.get();
            emp.setName(name);
            emp.setSalary(salary);
            return repo.save(emp);
        }
        return null;
    }

    // Delete Employee
    public void deleteEmployee(Long id) {
        repo.deleteById(id);
    }
}