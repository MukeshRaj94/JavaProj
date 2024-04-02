package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.Address;

@Service
public class AddressService {

	@Autowired
	AddressDao aDao;
	
	public ResponseEntity<Address> getAddressId(Integer id) {
		Address addr= aDao.findById(id).get();
		
		return new ResponseEntity<Address>(addr,HttpStatus.OK);
	}

}
