package com.example.demo.crud.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UpdateEmployeeResponse {
	 int id;
	 String name;
	 int salary;
	 String department;
	 int status;
	 String message;
}
