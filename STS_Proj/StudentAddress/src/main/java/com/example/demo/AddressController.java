package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Address;

@RestController
public class AddressController {

	@Autowired
	AddressService addrServ;
	
	@GetMapping("/getAddressId/{id}")
	public ResponseEntity<Address> getAddressId(@PathVariable Integer id) {
		
		return addrServ.getAddressId(id);
	}
}
