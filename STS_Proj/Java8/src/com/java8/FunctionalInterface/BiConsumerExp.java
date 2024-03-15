package com.java8.FunctionalInterface;

import java.util.List;
import java.util.function.BiConsumer;

import com.java8.data.Student;
import com.java8.data.StudentDataBase;

public class BiConsumerExp {
	static List<Student> std= StudentDataBase.getAllStudents();
	
	public static void nameActivities() {
		BiConsumer<String, List<String>> biCon = (name, std)->{System.out.println(name+":"+std);};
		
		std.forEach(student -> biCon.accept(student.getName(), student.getActivities()));
	}

	public static void main(String[] args) {
		BiConsumer<Integer,Integer> bi = (a,b)->{System.out.println(a+b);};
		bi.accept(3, 2);
		
		nameActivities();
	}


}
