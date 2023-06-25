package com.example.demo.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.crud.entity.Employee;
import com.example.demo.crud.exceptions.IdMismatchException;
import com.example.demo.crud.exceptions.NoEmployeeFoundException;
import com.example.demo.crud.model.EmployeeRequest;
import com.example.demo.crud.model.EmployeeResponse;
import com.example.demo.crud.model.GetEmployeeResponse;
import com.example.demo.crud.model.UpdateEmployeeRequest;
import com.example.demo.crud.model.UpdateEmployeeResponse;
import com.example.demo.crud.service.EmployeeServiceImpl;

@RestController
@RequestMapping("/v1")
public class EmployeeController {
	
	@Autowired
	EmployeeServiceImpl service;
	

		@PostMapping(value = "/addaEmployee",consumes = "application/json")
		public EmployeeResponse addingEmployee(@RequestBody EmployeeRequest request) throws IdMismatchException{
			System.out.println(request);
			EmployeeResponse e = service.addingEmployee(request);
			return e;
		}
		
		@GetMapping("/getEmployee/{id}")
		public GetEmployeeResponse getaEmployee(@PathVariable int id) throws NoEmployeeFoundException {
			//System.out.println(l);
			GetEmployeeResponse response = service.getEmployeeBasedOnId(id);
			return response;
		}
		
		@GetMapping("/getEmployees")
		public List<Employee> getAllEmployees(){
			List<Employee> l = service.getAllEmployees();
			return l;
		}
		
		@PutMapping("/updateEmployee/{id}")
		public UpdateEmployeeResponse updateEmployee(@PathVariable int id,@RequestBody UpdateEmployeeRequest request) throws NoEmployeeFoundException,IdMismatchException{
			UpdateEmployeeResponse response = service.updateEmployee(id, request);
			return response;
		}
		
		@GetMapping("/greet")
		public String greeting() {
			return "Hi";
		}
}
