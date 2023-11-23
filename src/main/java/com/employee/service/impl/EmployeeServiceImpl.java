package com.employee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.exception.ResourceNotFoundException;
import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;
import com.employee.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> ListAllEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	public String deleteEmployee(Long empid) {
		Employee emp = employeeRepository.findById(empid).orElseThrow(()->new ResourceNotFoundException("Employee", "Id", empid));
		employeeRepository.delete(emp);
		return "Employee "+emp.getFirstName()+" deleted successfully";
		
	}

	@Override
	public Employee updateEmployee(Long empid,Employee employee) {
		Employee emp=employeeRepository.findById(empid).orElseThrow(()->new ResourceNotFoundException("Employee", "Id", empid));
		emp.setEmailId(employee.getEmailId());
		emp.setFirstName(employee.getFirstName());
		emp.setLastName(employee.getLastName());
		
		return employeeRepository.save(emp);
	}

	@Override
	public Employee getEmployee(Long empid) {
		return employeeRepository.findById(empid).orElseThrow(()->new ResourceNotFoundException("Employee", "Id", empid));
	}

}
