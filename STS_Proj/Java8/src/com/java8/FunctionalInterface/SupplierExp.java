package com.java8.FunctionalInterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import com.java8.data.Student;
import com.java8.data.StudentDataBase;

public class SupplierExp {
	
	public static void main(String[] args) {
		Supplier<Student> supp = () ->{
			return new Student("Adam",2,3.6, "male",10,Arrays.asList("swimming", "basketball","volleyball"));
		};
		
		System.out.println("SupplierExp:"+ supp.get());
		
		Supplier<List<Student>> suppl = () ->{
			return StudentDataBase.getAllStudents();
		};
		
		System.out.println("Supplier:" +suppl.get());;
	
	}
	
}
