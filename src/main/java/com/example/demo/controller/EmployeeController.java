package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.EmployeeRequest;
import com.example.demo.model.EmployeeResponse;
import com.example.demo.service.EmployeeServiceImpl;

@RestController
@RequestMapping("/v1")
public class EmployeeController {
	
	@Autowired
	EmployeeServiceImpl service;
	

		@PostMapping(value = "/addaEmployee",consumes = "application/json")
		public EmployeeResponse addingEmployee(@RequestBody EmployeeRequest request) {
			System.out.println(request);
			EmployeeResponse e = service.addingEmployee(request);
			return e;
		}
		
		@GetMapping("/greet")
		public String greeting() {
			return "Hi";
		}
}
