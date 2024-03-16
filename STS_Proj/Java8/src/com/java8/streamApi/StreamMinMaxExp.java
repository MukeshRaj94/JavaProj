package com.java8.streamApi;

import java.util.Arrays;
import java.util.List;

public class StreamMinMaxExp {
	public static void main(String[] args) {
		List<Integer> lstVal = Arrays.asList(6,7,8,9,10);
		System.out.println("Max Value::"+lstVal.stream()
			.reduce(0, (x,y) -> x>y?x:y));
 	}
}
