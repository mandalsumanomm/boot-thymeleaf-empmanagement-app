package com.example.employeemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.employeemanagement.model.Employee;
import com.example.employeemanagement.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	 @Autowired
	    private EmployeeService employeeService;

	    @GetMapping
	    public String listEmployees(Model model) {
	        List<Employee> employees = employeeService.getAllEmployees();
	        model.addAttribute("employees", employees);
	        return "employees/list";
	    }

	    @GetMapping("/new")
	    public String showForm(Model model) {
	        model.addAttribute("employee", new Employee());
	        return "employees/form";
	    }

	    @PostMapping("/save")
	    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
	        employeeService.saveEmployee(employee);
	        return "redirect:/employees";
	    }

	    @GetMapping("/edit/{id}")
	    public String editEmployee(@PathVariable Long id, Model model) {
	        Employee employee = employeeService.getEmployeeById(id);
	        model.addAttribute("employee", employee);
	        return "employees/form";
	    }

	    @GetMapping("/delete/{id}")
	    public String deleteEmployee(@PathVariable Long id) {
	        employeeService.deleteEmployee(id);
	        return "redirect:/employees";
	    }
}
