package com.example.ems_backend.service;

import java.util.List;

import com.example.ems_backend.dto.EmployeeDto;

// Controller Layer depends upon the service layer.This layer contains the business Logic
public interface EmployeeService {
	EmployeeDto createEmployee(EmployeeDto employeeDto);
	EmployeeDto getEmployeeById(Long employeeId);
	List<EmployeeDto> getAllEmployees();
	EmployeeDto updateEmployee(Long employeeId,EmployeeDto updatedEmployee);
	void deleteEmployee(Long employeeId);
}
