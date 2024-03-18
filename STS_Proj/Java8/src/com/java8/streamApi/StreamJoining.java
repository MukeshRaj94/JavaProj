package com.java8.streamApi;

import java.util.stream.Collectors;

import com.java8.data.Student;
import com.java8.data.StudentDataBase;

public class StreamJoining {
	public static void main(String[] args) {
		System.out.println(StudentDataBase.getAllStudents()
				.stream()
				.map(Student::getName)
				.collect(Collectors.joining()));
		System.out.println(StudentDataBase.getAllStudents()
				.stream()
				.map(Student::getName)
				.collect(Collectors.joining("-")));
		System.out.println(StudentDataBase.getAllStudents()
				.stream()
				.map(Student::getName)
				.collect(Collectors.joining("-","(",")")));;
	}
}
