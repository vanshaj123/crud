package com.example.demo.crud.service;

import java.util.List;

import com.example.demo.crud.entity.Employee;
import com.example.demo.crud.exceptions.IdMismatchException;
import com.example.demo.crud.exceptions.NoEmployeeFoundException;
import com.example.demo.crud.model.EmployeeRequest;
import com.example.demo.crud.model.EmployeeResponse;
import com.example.demo.crud.model.GetEmployeeResponse;
import com.example.demo.crud.model.UpdateEmployeeRequest;
import com.example.demo.crud.model.UpdateEmployeeResponse;

public interface EmployeeService {
	
	public EmployeeResponse addingEmployee(EmployeeRequest empRequest) throws IdMismatchException;
	
	public GetEmployeeResponse getEmployeeBasedOnId(int id) throws NoEmployeeFoundException;
	
	public List<Employee> getAllEmployees();
	
	public UpdateEmployeeResponse updateEmployee(int id,UpdateEmployeeRequest empRequest) throws NoEmployeeFoundException,IdMismatchException;
}
