package com.java8.streamApi;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.java8.data.Student;
import com.java8.data.StudentDataBase;

public class StreamExample {
	
	public static void main(String[] args) {
		
		Predicate<Student> p1 = student -> student.getGradeLevel()>=3 ;
		Predicate<Student> p2 = student -> student.getGpa()>=3.9;
		
		Map<String, List<String>> mapStd = StudentDataBase.getAllStudents().stream()
				.filter(p1)
				.filter(p1)
			.collect(Collectors.toMap(Student::getName, Student::getActivities));
		
		System.out.println(mapStd);	
		
		List<String> lstStr = new ArrayList<>();
		lstStr.add("Check1");
		lstStr.add("Check2");
		lstStr.add("Check3");
		
	}

}
