package com.example.demo.crud.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.crud.entity.Employee;
import com.example.demo.crud.exceptions.IdMismatchException;
import com.example.demo.crud.exceptions.NoEmployeeFoundException;
import com.example.demo.crud.model.EmployeeRequest;
import com.example.demo.crud.model.EmployeeResponse;
import com.example.demo.crud.model.GetEmployeeResponse;
import com.example.demo.crud.model.UpdateEmployeeRequest;
import com.example.demo.crud.model.UpdateEmployeeResponse;

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
	public EmployeeResponse addingEmployee(EmployeeRequest empRequest) throws IdMismatchException {
		// TODO Auto-generated method stub
		int flag = 0;
		for(Employee e1 : l) {
			if(e1.getId()==empRequest.id) {
				flag=1;
				break;
			}
		}
		
		if(flag==1) {
			throw new IdMismatchException("Employee with id " + empRequest.getId() + " already exists. Kindly create a new employee with another id");
		}
		else {
		e  = new Employee(empRequest.id,empRequest.name,empRequest.salary,empRequest.department);
		l.add(e);
		EmployeeResponse response = new EmployeeResponse(e.getId(),e.getName(),e.getSalary(),e.getDepartment(),201,"Employee is created successfully");
		return response;
		}
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

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return l;
	}

	@Override
	public UpdateEmployeeResponse updateEmployee(int id, UpdateEmployeeRequest empRequest) throws NoEmployeeFoundException,IdMismatchException {
		// TODO Auto-generated method stub
//		List<Employee> l1 = l.stream()
//				.filter(x -> (x.getId()==id))
//				.collect(Collectors.toList());
//		System.out.println(l1);
		int flag = 0;
		int index = 0;
		for(Employee e1 : l) {
			if(e1.getId()==id) {
				flag = 1;
				index = l.indexOf(e1);
			}
		}
		if(flag==0) {
			throw new NoEmployeeFoundException("Employee with id " + id + " does not exist");
		}
		
		else if(empRequest.getId() != id) {
			throw new IdMismatchException("Id " + id + " does not match the id given in the update Employee request. Kindly check the ids and then try again");
		}
		else {
			l.remove(index);
			 l.add(index, new Employee(empRequest.getId(),empRequest.getName(),empRequest.getSalary(),empRequest.getDepartment())); 
			 System.out.println(l.get(index).getName());
			UpdateEmployeeResponse response = new UpdateEmployeeResponse(l.get(index).getId(),l.get(index).getName(),l.get(index).getSalary(),l.get(index).getDepartment(),202,"Employee is updated successfully");
			return response;
		}
		
	}

}
