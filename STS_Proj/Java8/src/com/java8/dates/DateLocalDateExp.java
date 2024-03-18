package com.java8.dates;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

public class DateLocalDateExp {
	public static void main(String[] args) {
		/*
		 * java.util.Date to localdate
		 */
		Date dt = new Date();
		System.out.println("Normal date::"+dt);
		LocalDate ldt = dt.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();;
		System.out.println(ldt);
		
		/**
		 * vice versa
		 */
		Date dt1 = new Date()
				.from(ldt.atTime(LocalTime.now()).atZone(ZoneId.systemDefault()).toInstant());
		System.out.println(dt1);
	}
}
