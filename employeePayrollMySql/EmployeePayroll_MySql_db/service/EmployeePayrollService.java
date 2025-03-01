package com.example.employeePayrollMySql.EmployeePayroll_MySql_db.service;


import com.example.employeePayrollMySql.EmployeePayroll_MySql_db.model.Employee;
import com.example.employeePayrollMySql.EmployeePayroll_MySql_db.repository.EmployeePayrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EmployeePayrollService {
    // uc2 section1
    @Autowired
    private EmployeePayrollRepository repo;

    // Create Employee
    public Employee createEmployee(Employee employee) {
        return repo.save(employee);
    }

    // Get All Employees
    public List<Employee> getAllEmployees() {
        return repo.findAll();
    }

    // Get Employee by ID
    public Optional<Employee> getEmployeeById(Long id) {
        return repo.findById(id);
    }

    // Update Employee
    public Optional<Employee> updateEmployee(Long id, Employee updatedEmployee) {
        return repo.findById(id).map(employee -> {
            employee.setName(updatedEmployee.getName());
            employee.setSalary(updatedEmployee.getSalary());
            return repo.save(employee);
        });
    }

    // Delete Employee
    public boolean deleteEmployee(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }
}