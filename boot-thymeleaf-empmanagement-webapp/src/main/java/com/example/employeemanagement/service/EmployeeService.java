package com.example.employeemanagement.service;

import java.util.List;

import com.example.employeemanagement.model.Employee;

public interface EmployeeService {

	 List<Employee> getAllEmployees();

	    Employee getEmployeeById(Long id);

	    void saveEmployee(Employee employee);

	    void deleteEmployee(Long id);
}
