package com.java8.FunctionalInterface;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Predicate;

import com.java8.data.Student;
import com.java8.data.StudentDataBase;

public class BiFuncExp {
	
	private static Map<String, Double> mapVal = new HashMap<>();
	static BiFunction<List<Student>,Predicate<Student>,Map<String,Double>> bifunc = (students, studentPred) -> {
		students.forEach(stud -> {
			if(studentPred.test(stud)) {
				mapVal.put(stud.getName(),stud.getGpa());
			}
		});
		return mapVal;
	};

	public static void main(String[] args) {
		System.out.println(bifunc.apply(StudentDataBase.getAllStudents(), PredicateStudExp.p2));;
	}
}
