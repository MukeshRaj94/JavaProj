package com.java8.streamApi;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import com.java8.data.Student;
import com.java8.data.StudentDataBase;

public class StreamFlatMapExp {
	static Consumer<Student> con = student -> System.out.println(student);;
	
	static public List<String> printStudentDetails(){
		List<String> stdDetails = StudentDataBase.getAllStudents()
				.stream()
				.map(Student::getActivities)//stream<List<string>>
				.flatMap(List::stream)//Stream<String>
				.distinct()
				.sorted()
				.collect(Collectors.toList());
		return stdDetails;
	}
	
	static public long printActivitiesCount(){
		long stdDetails = StudentDataBase.getAllStudents()
				.stream()
				.map(Student::getActivities)//stream<List<string>>
				.flatMap(List::stream)//Stream<String>
				.distinct()
				.count();
		return stdDetails;
	}
	
	public static void main(String[] args) {
		 System.out.println(printStudentDetails());
		 System.out.println(printActivitiesCount());
	}
}
