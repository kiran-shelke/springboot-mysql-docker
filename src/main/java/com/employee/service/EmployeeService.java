package com.employee.service;

import java.util.List;

import com.employee.model.Employee;

public interface EmployeeService {

	public Employee saveEmployee(Employee employee);
	public List<Employee> ListAllEmployee();
	public String deleteEmployee(Long empid);
	public Employee updateEmployee(Long empid,Employee employee);
	public Employee getEmployee(Long empid);

}
