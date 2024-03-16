package com.java8.streamApi;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.java8.data.Student;
import com.java8.data.StudentDataBase;

public class FilterExample {
	
	public static List<Student> getOnlyFemaleStudents(){
		return StudentDataBase.getAllStudents()
				.stream()
				.filter(student -> student.getGender().equals("female"))
				.collect(Collectors.toList());
	}
	
	public static List<Student> getStdWithNameSort(){
		return StudentDataBase.getAllStudents()
				.stream()
//				.map(Student::getName)
				.sorted(Comparator.comparing(Student::getName))
				.collect(Collectors.toList());
	}
	
	public static void main(String[] args) {
		getOnlyFemaleStudents().forEach(System.out::println);
		getStdWithNameSort().forEach(System.out::println);;
	}
}
