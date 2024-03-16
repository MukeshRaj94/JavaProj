package com.java8.streamApi;

import com.java8.data.Student;
import com.java8.data.StudentDataBase;

public class MapFilterReduceExp {
	
	public static int noOfNoteBooks() {
		int noteBk;
		noteBk = StudentDataBase.getAllStudents()
				.stream()
				.filter(s-> s.getGradeLevel()>=3)
				.map(Student::getNoteBooks)
//				.reduce((a,b)-> a+b)
				.reduce(Integer::sum)
				.orElse(0);
		return noteBk;
	}
	
	public static void main(String[] args) {
		System.out.println(noOfNoteBooks());
	}
}
