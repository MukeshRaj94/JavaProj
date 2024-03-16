package com.java8.streamApi;

import java.util.List;import java.util.TooManyListenersException;
import java.util.stream.Collectors;

import com.java8.data.Student;
import com.java8.data.StudentDataBase;

public class StreamMapExample {
	
	public static List<String> namesList(){
		
		List<String> nameLst = StudentDataBase.getAllStudents()
				.stream()
				.map(Student::getName)
				.collect(Collectors.toList());
		return nameLst;
	}
	public static void main(String[] args) {
		System.out.println(namesList());
	}
}
