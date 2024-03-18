package com.java8.streamApi;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

import com.java8.data.Student;
import com.java8.data.StudentDataBase;

public class StreamCompareUsingManyObjects {

	private static Consumer<Student> cons = s->System.out.println(s);
	private static Comparator<Student> compar = Comparator.comparing(Student::getName);
	private static Comparator<Student> compar1 = Comparator.comparing(Student::getGradeLevel);
	
	public static void ComparewithDiffByNames(List<Student> stdLst) {	
		
		stdLst.sort(compar);
		stdLst.forEach(cons);
	}
	
	public static void ComparewithDiffByGrade(List<Student> stdLst) {
		
		stdLst.sort(compar1);
		stdLst.forEach(cons);
	}
	
	public static void ComparewithDiffByBothParam(List<Student> stdLst) {
		
		stdLst.sort(compar1.thenComparing(compar));
		stdLst.forEach(cons);
	}
	
	public static void main(String[] args) {
		List<Student> stdLst = StudentDataBase.getAllStudents();
		System.out.println("Before Sorting");
		stdLst.forEach(cons);
		System.out.println("After Sorting Name");
		ComparewithDiffByNames(stdLst);
		System.out.println("After Sorting Grade");
		ComparewithDiffByGrade(stdLst);
		System.out.println("After Sorting ByBoth");
		ComparewithDiffByBothParam(stdLst);
	}
}
