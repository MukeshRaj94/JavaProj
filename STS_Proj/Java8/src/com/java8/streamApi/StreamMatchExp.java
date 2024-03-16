package com.java8.streamApi;

import com.java8.data.StudentDataBase;

public class StreamMatchExp {
	public static void main(String[] args) {
		System.out.println(StudentDataBase.getAllStudents().stream()
				.allMatch(s -> s.getGpa()>= 3.5));
		
		System.out.println(StudentDataBase.getAllStudents().stream()
				.anyMatch(s -> s.getGpa()>= 4.1));
		
		System.out.println(StudentDataBase.getAllStudents().stream()
				.noneMatch(s -> s.getGpa()>= 4.1));
	}
}
