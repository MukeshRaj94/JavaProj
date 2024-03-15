package com.java8.FunctionalInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import com.java8.data.Student;
import com.java8.data.StudentDataBase;

public class ConsumerExample {
	
	List<Student> std= StudentDataBase.getAllStudents();
	Consumer<Student> con =  (student) -> System.out.println(student);
	Consumer<Student> con1 =  (student) -> System.out.print(student.getName());
	Consumer<Student> con2 =  (student) -> System.out.println(student.getActivities());
	Consumer<Student> con3 =  (student) -> System.out.println(student.getGradeLevel());
	
	public void getAllNames() {
		
		std.forEach(con);
	}
	
	public void getAllNamesActivities() {
		
		std.forEach(con1.andThen(con2));
	}
	
	public void getAllNamesActivitiesUsingCondition() {
		
		std.forEach(student -> {
			if(student.getGradeLevel() >=3)
				con1.andThen(con3).accept(student);
		});
	}
	
	public static void main(String[] args) {
		ConsumerExample conExp = new ConsumerExample();
		conExp.getAllNames();
		conExp.getAllNamesActivities();
		conExp.getAllNamesActivitiesUsingCondition();
	}
}
