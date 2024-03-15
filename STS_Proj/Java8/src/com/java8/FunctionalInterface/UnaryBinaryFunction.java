package com.java8.FunctionalInterface;

import java.util.Comparator;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class UnaryBinaryFunction {
	
	static UnaryOperator<Integer> ut = a -> a+2;
	static BinaryOperator<Integer> bt = (a,b) -> a+b;
	static Comparator<Integer> comp = (a,b) -> a.compareTo(b);

	public static void main(String[] args) {
		System.out.println("Unary Operator::"+ut.apply(2));
		System.out.println("Binary Operator::"+bt.apply(2, 3));
		System.out.println("Binary Operator::"+BinaryOperator.minBy(comp).apply(2, 3));
	}
}
