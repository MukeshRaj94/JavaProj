package com.java8.NumericStream;

import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class NumericStreamsRangesExp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(IntStream.range(1, 50).count());
		System.out.println(IntStream.rangeClosed(1, 50).count());
		System.out.println(LongStream.range(1, 50).count());
		System.out.println(LongStream.rangeClosed(1, 50).count());
		
		System.out.println("Sum::"+IntStream.range(1, 50).sum());
		
		OptionalInt minStream = IntStream.range(1, 50).min();
		System.out.println("minStream::"+minStream.isPresent());
		System.out.println("Min::"+(minStream.isPresent()?minStream:0));
		
		OptionalLong maxStream = LongStream.range(1, 50).max();
		System.out.println("maxStream::"+maxStream.isPresent());
		System.out.println("maxStream::"+(maxStream.isPresent()?maxStream:0));
		
		OptionalDouble avgStream = LongStream.range(1, 50).asDoubleStream().average();
		System.out.println("avgStream::"+avgStream.isPresent());
		System.out.println("avgStream::"+(avgStream.isPresent()?avgStream:0));
	}
}
