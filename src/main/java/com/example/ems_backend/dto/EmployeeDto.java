package com.example.ems_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Dto object is used to transfer data between client and server it helps to reduce the remote calls from client to server

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

	private long id;
	private String firstName;
	private String lastName;
	private String email;
}
