package com.example.ems_backend.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.ems_backend.dto.EmployeeDto;
import com.example.ems_backend.entity.Employee;
import com.example.ems_backend.exception.ResourceNotFoundException;
import com.example.ems_backend.mapper.EmployeeMapper;
import com.example.ems_backend.reporsitory.EmployeeRepository;
import com.example.ems_backend.service.EmployeeService;

import lombok.AllArgsConstructor;

@Service //creates spring bean for the class
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;
	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		// TODO Auto-generated method stub
		Employee employee=EmployeeMapper.maptoEmployee(employeeDto);
		Employee savedEmployee=employeeRepository.save(employee);
		
		return EmployeeMapper.maptoEmployeeDto(savedEmployee);
	}
	@Override
	public EmployeeDto getEmployeeById(Long employeeId) {
		// TODO Auto-generated method stub
		 Employee employee=employeeRepository
					 		.findById(employeeId)
							.orElseThrow(()->
									new ResourceNotFoundException("Employee doesnt exist with give id : "+employeeId));
		
		return EmployeeMapper.maptoEmployeeDto(employee);
	}
	@Override
	public List<EmployeeDto> getAllEmployees() {
		// TODO Auto-generated method stub
		List<Employee> employees=employeeRepository.findAll();	
		// conversion of Employee jpa entity to Employee Dto
		return employees
				.stream().map((employee)->EmployeeMapper
				.maptoEmployeeDto(employee))
				.collect(Collectors.toList());
	}
	@Override
	public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {
		// TODO Auto-generated method stub
		Employee employee=employeeRepository.findById(employeeId)
							.orElseThrow(()->new ResourceNotFoundException("Employee doesn't exist with given id: "+employeeId));
		employee.setFirstName(updatedEmployee.getFirstName());
		employee.setLastName(updatedEmployee.getLastName());
		employee.setEmail(updatedEmployee.getEmail());
		
		Employee updatedEmployeeObj=employeeRepository.save(employee);//perform both save and update operation
		return EmployeeMapper.maptoEmployeeDto(updatedEmployeeObj);
	}
	@Override
	public void deleteEmployee(Long employeeId) {
		// TODO Auto-generated method stub
		Employee employee=employeeRepository.findById(employeeId)
				.orElseThrow(()->new ResourceNotFoundException("Employee doesn't exist with given id: "+employeeId));
		employeeRepository.deleteById(employeeId);
		
	}
	
}
