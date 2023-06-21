package com.example.demo.service;

import com.example.demo.model.EmployeeRequest;
import com.example.demo.model.EmployeeResponse;

public interface EmployeeService {
	
	public EmployeeResponse addingEmployee(EmployeeRequest empRequest);
}
