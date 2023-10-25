package com.example.employeemanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employeemanagement.EmployeeRepository;
import com.example.employeemanagement.model.Employee;
@Service
public class EmployeeServiceImpl implements EmployeeService {

	 @Autowired
	    private EmployeeRepository employeeRepository;

	    @Override
	    public List<Employee> getAllEmployees() {
	        return employeeRepository.findAll();
	    }

	    @Override
	    public Employee getEmployeeById(Long id) {
	        return employeeRepository.findById(id).orElse(null);
	    }

	    @Override
	    public void saveEmployee(Employee employee) {
	        employeeRepository.save(employee);
	    }

	    @Override
	    public void deleteEmployee(Long id) {
	        employeeRepository.deleteById(id);
	    }

}
