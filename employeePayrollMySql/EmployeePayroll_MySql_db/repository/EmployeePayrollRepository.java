package com.example.employeePayrollMySql.EmployeePayroll_MySql_db.repository;


import com.example.employeePayrollMySql.EmployeePayroll_MySql_db.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeePayrollRepository extends JpaRepository<Employee, Long> {
}
