package com.java8.streamApi;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.java8.data.Student;
import com.java8.data.StudentDataBase;

public class StreamReduceExp {
	
	public static Optional<Student> getOpt() {
		Optional<Student> optStd = StudentDataBase.getAllStudents().stream()
			.reduce((a,b) -> a.getGpa() > b.getGpa() ? a:b);
		return optStd;
	}
	
	public static void main(String[] args) {
		List<Integer> lstInt = Arrays.asList(1,3,5);
		System.out.println(lstInt.stream()
			.reduce(1, (a,b) -> a*b));
		System.out.println("getOpt::"+getOpt().isPresent());
		System.out.println("getOpt::"+getOpt().get());;
	}
}
