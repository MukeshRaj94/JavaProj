package com.java8.NumericStream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumericBoxingUnBoxingStream {
	
	public static List<Integer> boxing() {
		List<Integer> lst = IntStream.rangeClosed(1, 5).boxed().collect(Collectors.toList());
		return lst;
	}
	
	public static int unBoxing(List<Integer> lst) {
		return lst.stream()
			.mapToInt(Integer::intValue)
			.sum();
	}
	
	public static void main(String[] args) {
		System.out.println(boxing());
		System.out.println(unBoxing(boxing()));
	}
}
