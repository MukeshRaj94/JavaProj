package com.java8.dates;

import java.time.LocalDate;
import java.time.Period;

public class PeriodExp {
	public static void main(String[] args) {
		LocalDate d1 = LocalDate.now();
		LocalDate d2 = LocalDate.of(2023, 02, 18);
		
		Period p = d1.until(d2);
		System.out.println("getDays::"+p.getDays());
		System.out.println("getMonth::"+p.getMonths());
		System.out.println("getYear::"+p.getYears());
		
		System.out.println(Period.ofDays(10).getDays());
		System.out.println(Period.ofMonths(2).getMonths());
		System.out.println(Period.ofYears(4).getYears());
		System.out.println(Period.ofYears(4).toTotalMonths());
		
		Period p1 = Period.between(d1, d2);
		System.out.println("p1::"+p1);
	}
}
