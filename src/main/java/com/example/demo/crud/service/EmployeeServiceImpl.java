package com.example.demo.crud.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.crud.entity.Employee;
import com.example.demo.crud.exceptions.NoEmployeeFoundException;
import com.example.demo.crud.model.EmployeeRequest;
import com.example.demo.crud.model.EmployeeResponse;
import com.example.demo.crud.model.GetEmployeeResponse;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	List<Employee> l = new ArrayList<>();
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
		l.add(e);
		EmployeeResponse response = new EmployeeResponse(e.getId(),e.getName(),e.getSalary(),e.getDepartment(),201,"Employee is created successfully");
		return response;
		
	}

	@Override
	public GetEmployeeResponse getEmployeeBasedOnId(int id) throws NoEmployeeFoundException{
		// TODO Auto-generated method stub
		
		List<Employee> l1 = l.stream()
						.filter(x -> (x.getId()==id))
						.collect(Collectors.toList());
		System.out.println(l1);
		if(l1.isEmpty()) {
			throw new NoEmployeeFoundException("Employee with id " + id + " does not exist");
		}
		else {
		Employee e1 = l1.get(0);
		GetEmployeeResponse response = new GetEmployeeResponse(e1.getId(),e1.getName(),e1.getSalary(),e1.getDepartment());
		return response;
		}
		
	}

}
