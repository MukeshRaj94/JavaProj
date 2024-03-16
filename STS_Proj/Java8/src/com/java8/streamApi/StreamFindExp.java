package com.java8.streamApi;

import com.java8.data.StudentDataBase;

public class StreamFindExp {
	public static void main(String[] args) {
		System.out.println(StudentDataBase.getAllStudents().stream()
				.filter(std -> std.getGpa()>= 3.9)
				//emily, dave, james
				.findAny()
				//emily found in the first itself and hence it returns
				);
		
		System.out.println(StudentDataBase.getAllStudents().stream()
				.filter(std -> std.getGpa()>= 3.8)
				//jenny, emily, dave, james
				.findFirst()
				//emily found in the first itself and hence it returns
				);
	}
}
