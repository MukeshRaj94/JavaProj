package com.java8.dates;

import java.time.LocalTime;
import java.time.temporal.ChronoField;

public class LocalTimeExp {
	public static void main(String[] args) {
		LocalTime localTime = LocalTime.now();
		System.out.println("localTime::"+localTime);
		
		LocalTime localTime1 = LocalTime.of(1,1);
		System.out.println("localTime1::"+localTime1);
		
		LocalTime localTime2 = LocalTime.of(1, 1, 1);
		System.out.println("localTime2::"+localTime2);
		
		LocalTime localTime3 = LocalTime.of(1, 1, 1,123213);
		System.out.println("localTime3::"+localTime3);
		
		/*
		 * Getting Value of time
		 */
		System.out.println("gethour::"+localTime.getHour());
		System.out.println("gethour::"+localTime.get(ChronoField.CLOCK_HOUR_OF_DAY));
		System.out.println("toNanoOfDay::"+localTime.toNanoOfDay());
		
	}
}
