package com.example.demo;

import  org.slf4j.LoggerFactory;

import java.util.List;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	private static final Logger log = LoggerFactory.getLogger(LoggingAspect.class);
	
	@Before("execution(public * com.example.demo.HomeControllerForRest.getAliens())")
	public void getLogBefore() {
		log.info("Before GetAlien methozd called");
	}
	
	@After("execution(public * com.example.demo.HomeControllerForRest.getAliens())")
	public void getLogAfter() {
		log.info("After finally GetAlien method called");
	}
	
	@AfterThrowing("execution(public * com.example.demo.HomeControllerForRest.getAliens())")
	public void getLogAfterThrow() {
		log.info("After Throw GetAlien method called");
	}
	
	@AfterReturning("execution(public * com.example.demo.HomeControllerForRest.getAliens())")
	public void getLogAfterSuccess() {
		log.info("After Success GetAlien method called");
	}
}
