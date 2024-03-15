package com.java8.FunctionalInterface;

import java.util.List;
import java.util.function.Predicate;

import com.java8.data.Student;
import com.java8.data.StudentDataBase;

public class PredicateStudExp {
	
	static List<Student> lst = StudentDataBase.getAllStudents();
	static Predicate<Student> p1 = (student) -> student.getGradeLevel() >= 3 ;
	static Predicate<Student> p2 =student -> student.getGpa() >= 4;
	
	static public void checkGradeLeve() {
		System.out.println("checkGradeLeve");
		lst.forEach((student) ->{
			if(p1.test(student)) System.out.println(student);;
		});
	}
	
	static public void checkGpa() {
		System.out.println("checkGpa");
		lst.forEach(student -> 		
		
		{if(p2.test(student))
			System.out.println(student);});
	}
	
	static public void checkStudents() {
		System.out.println("checkStudents");
		
		lst.forEach((student) ->{
			if(p1.and(p2).test(student))
			System.out.println(student);
		});
	}
	
	public static void main(String[] args) {
		System.out.println();
		checkGradeLeve();
		checkGpa();
		checkStudents();
	}


}
