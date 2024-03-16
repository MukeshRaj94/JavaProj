package com.java8.streamApi;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class StreamOfIteraeGenerate {
	public static void main(String[] args) {
		Stream<String> s1 = Stream.of("test","test");
		s1.forEach(System.out::println);
		
		Stream.iterate(0, a->a+2).limit(2).forEach(System.out::println);
		
		Supplier<Integer> suppl = new Random()::nextInt;
		Stream.generate(suppl).limit(2).forEach(System.out::println);
	}
}
