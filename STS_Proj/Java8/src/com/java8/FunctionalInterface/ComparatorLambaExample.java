package com.java8.FunctionalInterface;

import java.util.Comparator;

public class ComparatorLambaExample {

	public static void main(String[] args) {
		Comparator<Integer> comp = new Comparator<>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}
			
		};
		System.out.println("older:"+ comp.compare(3,2));
		Comparator<Integer> comp1 = ( a1, a2) -> {
			return a1.compareTo(a2);
		};
		
		System.out.println("older:"+ comp1.compare(3,2));
	}
	
}
