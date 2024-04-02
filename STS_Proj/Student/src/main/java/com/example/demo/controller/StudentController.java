package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Address;
import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@RestController
@EnableFeignClients
public class StudentController {

	@Autowired
	StudentService stdService;
	
	@PostMapping("/create")
	public ResponseEntity<String> createStudent(@RequestBody Student std) {
		
		return stdService.createStudent(std);
	}
	
	@GetMapping("/getid/{id}")
	public ResponseEntity<Student> getById(@PathVariable Long id) {
		
		return stdService.getById(id);
	}
	
	@GetMapping("/getAddressId/{id}")
	public ResponseEntity<Address> getAddressId(@PathVariable Integer id) {
		
		return stdService.getAddressId(id);
	}
	
}
