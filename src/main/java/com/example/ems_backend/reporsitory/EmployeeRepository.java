package com.example.ems_backend.reporsitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ems_backend.entity.Employee;

// EmplyeeRepository gets crud methods for performing operations
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
