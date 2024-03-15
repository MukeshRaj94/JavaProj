package com.java8.FunctionalInterface;
import java.util.function.Predicate;

public class PredicateExample {

	static Predicate<Integer> p = (i) -> {return i%2==0;};
	static Predicate<Integer> p1 = (i) -> {return i%5==0;};
	
	public static void predAnd() {
		 System.out.println(p.and(p1).test(19));
	}
	
	public static void predOr() {
		 System.out.println(p.or(p1).test(15));
	}
	
	public static void predNegate() {
		 System.out.println(p.negate().test(13));
	}
	
	public static void main(String[] args) {
		
//		System.out.println(p.test(2));
		predAnd();
		predOr();
		predNegate();
	}


}
