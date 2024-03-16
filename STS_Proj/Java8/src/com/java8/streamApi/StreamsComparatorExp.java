package com.java8.streamApi;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.java8.data.Student;
import com.java8.data.StudentDataBase;

public class StreamsComparatorExp {
	
	public static List<String> getAllNameWithSort(){
		List <String> stdLst = StudentDataBase.getAllStudents()
				.stream()
				.map(Student::getName)
				.sorted()
				.collect(Collectors.toList());
		return stdLst;
	}
	
	public static List<Student> getAllNameWithComparator(){
		List <Student> stdLst = StudentDataBase.getAllStudents()
				.stream()
				.sorted(Comparator.comparing(Student::getName))
				.collect(Collectors.toList());
		return stdLst;
	}
	
	public static List<Student> getAllNameWithComparatorGpa(){
		List <Student> stdLst = StudentDataBase.getAllStudents()
				.stream()
				.sorted(Comparator.comparing(Student::getGpa))
				.collect(Collectors.toList());
		return stdLst;
	}
	
	public static List<Student> getAllNameWithComparatorGpaReversed(){
		List <Student> stdLst = StudentDataBase.getAllStudents()
				.stream()
				.sorted(Comparator.comparing(Student::getGpa).reversed())
				.collect(Collectors.toList());
		return stdLst;
	}
	
	public static void main(String[] args) {
		getAllNameWithSort().forEach(System.out::println);
		System.out.println("Comparator::");;
		getAllNameWithComparator().forEach(System.out::println);
		System.out.println("Gpa::");
		getAllNameWithComparatorGpa().forEach(System.out::println);
		System.out.println("Gpa::Reverse::");
		getAllNameWithComparatorGpaReversed().forEach(System.out::println);;
	}
}
