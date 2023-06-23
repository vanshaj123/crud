package com.example.demo.crud.service;

import com.example.demo.crud.model.EmployeeRequest;
import com.example.demo.crud.model.EmployeeResponse;

public interface EmployeeService {
	
	public EmployeeResponse addingEmployee(EmployeeRequest empRequest);
}
