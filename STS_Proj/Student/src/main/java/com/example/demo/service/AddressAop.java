package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.FeignInterface;
import com.example.demo.model.Address;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class AddressAop {

	@Autowired
	FeignInterface fDao;
	
	
	@CircuitBreaker(name="addressService", fallBackMethod="fallBack")
	public Address getAddressById(Integer id) {
		return fDao.getAddressId(id).getBody();
	}
	
	public Address fallBack(Integer id) {
		return new Address();
	}
}
