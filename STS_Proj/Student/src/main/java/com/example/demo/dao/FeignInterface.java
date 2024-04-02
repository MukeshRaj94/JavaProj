package com.example.demo.dao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.model.Address;

@FeignClient("StudentAddress")
public interface FeignInterface {

	@GetMapping("/getAddressId/{id}")
	public ResponseEntity<Address> getAddressId(@PathVariable Integer id);
}
