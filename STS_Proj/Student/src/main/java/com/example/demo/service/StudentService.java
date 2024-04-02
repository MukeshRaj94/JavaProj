package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dao.FeignInterface;
import com.example.demo.dao.StudentDao;
import com.example.demo.model.Address;
import com.example.demo.model.Student;

@Service
public class StudentService {

	@Autowired
	StudentDao sDao;
	
//	@Autowired
//	AddressDao aDao;
	
	@Autowired
	FeignInterface fDao;
	
	@Autowired
	AddressAop addAop;
	
	public ResponseEntity<String> createStudent(Student std) {
		
//		System.out.println(std.getId()+std.getName()+std.getAge()+std.getAddress().getCity()+std.getAddress().getState());
		sDao.save(std);
		return new ResponseEntity<String>("success and created Student object",HttpStatus.OK);
	}

	public ResponseEntity<Student> getById(Long id) {
		Student stdlist = sDao.findById(id).get();
		return new ResponseEntity<Student>(stdlist,HttpStatus.OK);
	}

	public ResponseEntity<Address> getAddressId(Integer id) {
//		Address addr= aDao.findById(id).get();
		Address addr= addAop.getAddressById(id);
		return new ResponseEntity<Address>(addr,HttpStatus.OK);
	}

	

}
