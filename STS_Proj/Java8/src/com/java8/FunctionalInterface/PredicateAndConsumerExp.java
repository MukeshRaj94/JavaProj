 package com.java8.FunctionalInterface;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

import com.java8.data.Student;
import com.java8.data.StudentDataBase;

public class PredicateAndConsumerExp {
	
	static List<Student> stdList = StudentDataBase.getAllStudents();
	
	Predicate<Student> p1 = student -> student.getGpa()>=3.9;
	Predicate<Student> p2 = student -> student.getGradeLevel()>=3;
	
	BiPredicate<Double, Integer> biPred = (gpa,grade) -> {
		 return gpa >= 3.9 && grade >=3;
	};
	
	BiConsumer<String, List<String>> biCon = (name, activities) ->{
		System.out.println("name:"+name+"activites:"+activities);
	};
	
	Consumer<Student> c1 = student -> {
		if(p1.and(p2).test(student)) {
			biCon.accept(student.getName(), student.getActivities());
		}
	};
	
	public void predConsumerExp(List<Student> stdList) {
		stdList.forEach(c1);
		System.out.println();
	}
	
	public static void main(String[] args) {
		PredicateAndConsumerExp predCon = new PredicateAndConsumerExp();
		predCon.predConsumerExp(stdList);
	}
}
