package com.java8.streamApi;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.java8.data.Student;
import com.java8.data.StudentDataBase;

public class StreamPartioningByExp {
	
	public static void partionByExp() {
		Map<Boolean,List<Student>> stdMap = StudentDataBase.getAllStudents()
			.stream()
			.collect(Collectors.partitioningBy(s->s.getGpa()>=3.8));
		System.out.println("stdMap::"+stdMap);;
	}
	
	public static void partionByExp_2() {
		System.out.println("partionByExp_2::");
		Map<Boolean,Set<Student>> stdMap = StudentDataBase.getAllStudents()
			.stream()
			.collect(Collectors.partitioningBy(s->s.getGpa()>=3.8,
					Collectors.toSet()));
		System.out.println("stdMap::"+stdMap);
	}
	
	public static void main(String[] args) {
		partionByExp();
		partionByExp_2();
	}
}
