package com.java8.FunctionalInterface;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import com.java8.data.Student;
import com.java8.data.StudentDataBase;

public class FunctionInt2 {
	
	static Function<List<Student>,Map<String,Double>> lstStd = (students) -> {
		Map<String, Double> mapVal = new HashMap<>();
		students.forEach(student -> {
			mapVal.put(student.getName(),student.getGpa());
		});
		return mapVal;
	};

	public static void main(String[] args) {
		System.out.println(lstStd.apply(StudentDataBase.getAllStudents()));;
	}
}
