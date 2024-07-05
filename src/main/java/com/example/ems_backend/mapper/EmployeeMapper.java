package com.example.ems_backend.mapper;

import com.example.ems_backend.dto.EmployeeDto;
import com.example.ems_backend.entity.Employee;

//Mapper methods can be reused throughout the application wherever the conversion 
//between entity and DTO (Data Transfer Object) is needed. This reduces code duplication.

public class EmployeeMapper {
	
	// map employee enitiy to employeeDto
	public static EmployeeDto maptoEmployeeDto(Employee employee) {
		return new EmployeeDto(
				employee.getId(),
				employee.getFirstName(),
				employee.getLastName(),
				employee.getEmail()
				);	
	}
	
	// map employeeDto to employee enitity
	public static Employee maptoEmployee(EmployeeDto employeeDto) {
		return new Employee(
				employeeDto.getId(),
				employeeDto.getFirstName(),
				employeeDto.getLastName(),
				employeeDto.getEmail()
				);	
	}
}
