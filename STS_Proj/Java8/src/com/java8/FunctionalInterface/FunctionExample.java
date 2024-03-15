package com.java8.FunctionalInterface;

import java.util.function.Function;

public class FunctionExample {

	static Function<String, String> func = (name) -> name.toUpperCase();
	static Function<String, String> func1 = (name) -> name.toUpperCase().concat("Features");
	
	public static void main(String[] args) {
		System.out.println(func.apply("Java8"));
		System.out.println(func.andThen(func1).apply("Java8"));
		System.out.println(func.compose(func1).apply("Java8"));
	}
}
