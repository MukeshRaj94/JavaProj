package com.java8.streamApi;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import com.java8.data.Student;
import com.java8.data.StudentDataBase;

public class StreamGroupingExp {
	public static void grouping() {
		Map<String,List<Student>> stgMap= StudentDataBase.getAllStudents()
			.stream()
			.collect(Collectors.groupingBy(Student::getGender));
		System.out.println(stgMap);
	}
	
	public static void grouping1() {
		Map<String,List<Student>> stgMap= StudentDataBase.getAllStudents()
			.stream()
			.collect(Collectors.groupingBy(s->s.getGpa()>=3.8?"Super":"Avg"));
		System.out.println(stgMap);
	}
	
	public static void twoLevelGrouping1() {
		System.out.println("Two Level Grouping::");
		Map<Integer,Map<String,List<Student>>> stgMap= StudentDataBase.getAllStudents()
			.stream()
			.collect(Collectors.groupingBy(Student::getGradeLevel,
					Collectors.groupingBy(s->s.getGpa()>=3.8?"Super":"Avg")));
		System.out.println(stgMap);
	}
	
	public static void twoLevelGrouping2() {
		System.out.println("Two Level Grouping:2:");
		Map<Integer,Integer> stgMap= StudentDataBase.getAllStudents()
			.stream()
			.collect(Collectors.groupingBy(Student::getGradeLevel,
					Collectors.summingInt(Student::getNoteBooks)));
		System.out.println(stgMap);
	}
	
	public static void threeLevelGrouping3() {
		System.out.println("Three Level Grouping::");
		Map<String,Set<Student>> stgMap= StudentDataBase.getAllStudents()
			.stream()
			.collect(Collectors.groupingBy(Student::getName,
					LinkedHashMap::new,
					Collectors.toSet()));
		System.out.println(stgMap);
	}
	
	public static void calculateTopGpa() {
		System.out.println("Calculate Top Gpa");
		Map<Integer,Optional<Student>> stdMap = StudentDataBase.getAllStudents()
			.stream()
			.collect(Collectors.groupingBy(Student::getGradeLevel, 
					Collectors.maxBy(Comparator.comparing(Student::getGpa))));
		System.out.println(stdMap);
		Map<Integer,Student> stdMap1 = StudentDataBase.getAllStudents()
				.stream()
				.collect(Collectors.groupingBy(Student::getGradeLevel, 
						Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Student::getGpa)),
								Optional::get)));
		System.out.println(stdMap1);
	}
	
	public static void calculateLeastGpa() {
		System.out.println("Calculate Least Gpa");
		Map<Integer,Optional<Student>> stdMap = StudentDataBase.getAllStudents()
			.stream()
			.collect(Collectors.groupingBy(Student::getGradeLevel, 
					Collectors.minBy(Comparator.comparing(Student::getGpa))));
		System.out.println(stdMap);
		Map<Integer,Student> stdMap1 = StudentDataBase.getAllStudents()
				.stream()
				.collect(Collectors.groupingBy(Student::getGradeLevel, 
						Collectors.collectingAndThen(Collectors.minBy(Comparator.comparing(Student::getGpa)),
								Optional::get)));
		System.out.println(stdMap1);
	}
	
	public static void main(String[] args) {
		grouping();
		grouping1();
		twoLevelGrouping1();
		twoLevelGrouping2();
		threeLevelGrouping3();
		calculateTopGpa();
		calculateLeastGpa();
	}
}
