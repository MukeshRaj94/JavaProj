package com.example.demo;

import java.beans.beancontext.BeanContext;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SampleSpringCore {

	public static void main(String[] args) {
		SpringApplication.run(SampleSpringCore.class, args);
	}

}
