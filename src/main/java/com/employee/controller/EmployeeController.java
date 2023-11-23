package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.model.Employee;
import com.employee.service.EmployeeService;

@RestController
@RequestMapping("/v1/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	//save employee
	@PostMapping()
	public Employee savetEmployee(@RequestBody Employee emp)
	{
		return employeeService.saveEmployee(emp);
	}
	
	//get all employee
	@GetMapping()
	public List<Employee> getAllEmployee()
	{
		return employeeService.ListAllEmployee();
	}
	
	//get single employee
	@GetMapping("/{empid}")
	public Employee getEmployee(@PathVariable Long empid)
	{
		return employeeService.getEmployee(empid);
	}
	
	//delete employee
	@DeleteMapping("/{empid}")
	public String deleteEmployee(@PathVariable Long empid)
	{
		return employeeService.deleteEmployee(empid);
	}
	
	//update employee
	@PutMapping("/{empid}")
	public Employee updateEmployee(@PathVariable Long empid,@RequestBody Employee emp)
	{
		return employeeService.updateEmployee(empid,emp);
	}

}
