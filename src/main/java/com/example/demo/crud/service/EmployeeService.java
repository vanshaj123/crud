package com.example.demo.crud.service;

import com.example.demo.crud.model.EmployeeRequest;
import com.example.demo.crud.model.EmployeeResponse;
import com.example.demo.crud.model.GetEmployeeResponse;

public interface EmployeeService {
	
	public EmployeeResponse addingEmployee(EmployeeRequest empRequest);
	
	public GetEmployeeResponse getEmployeeBasedOnId(int id);
}
