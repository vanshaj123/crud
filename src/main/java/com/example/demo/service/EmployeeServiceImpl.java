package com.example.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import com.example.demo.entity.Employee;
import com.example.demo.model.EmployeeRequest;
import com.example.demo.model.EmployeeResponse;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	Map<Integer,Employee> l = new HashMap<>();
	Employee e;

//	@Override
//	public EmployeeResponse createEmployee(EmployeeRequest empRequest) {
//		// TODO Auto-generated method stub
//		e  = new Employee();
//		l.put();
//		EmployeeResponse response = new EmployeeResponse();
//		return response;
//	}

	@Override
	public EmployeeResponse addingEmployee(EmployeeRequest empRequest) {
		// TODO Auto-generated method stub
		e  = new Employee(empRequest.id,empRequest.name,empRequest.salary,empRequest.department);
		l.put(e.getId(),e);
		EmployeeResponse response = new EmployeeResponse(e.getId(),e.getName(),e.getSalary(),e.getDepartment(),201,"Employee is created successfully");
		return response;
		
	}

}
