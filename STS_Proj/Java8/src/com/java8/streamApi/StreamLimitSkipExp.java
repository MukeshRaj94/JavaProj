package com.java8.streamApi;

import java.util.Arrays;
import java.util.List;

public class StreamLimitSkipExp {
	public static void main(String[] args) {
		List<Integer> lst = Arrays.asList(1,2,3,4,5);
		System.out.println(lst.stream()
				//1,2,3,4,5
				.limit(2)
				//1,2
				.reduce((a,b) -> a+b));
		System.out.println(lst.stream()
				//1,2,3,4,5
				.skip(2)
				//3,4,5
				.reduce((a,b) -> a+b));
	}
}
