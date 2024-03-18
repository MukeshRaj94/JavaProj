package com.java8.dates;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class LocalDateExp {
	public static void main(String[] args) {
		LocalDate lclDt = LocalDate.now();
		System.out.println("lclDt::"+lclDt);
		
		LocalDate lclDt1 = LocalDate.of(2024, 7, 1);
		System.out.println("lclDt1::"+lclDt1);
		
		LocalDate lclDt2 = LocalDate.ofYearDay(2023, 90);
		System.out.println("lclDt2::"+lclDt2);
		
		System.out.println("getDayOfMonth::"+lclDt.getDayOfMonth());
		System.out.println("getDayOfYear::"+lclDt.getDayOfYear());
		System.out.println("getMonthValue::"+lclDt.getMonthValue());
		System.out.println("getMonth::"+lclDt.getMonth());
		System.out.println("getChronology::"+lclDt.getChronology());
		System.out.println("getChronology::"+lclDt.get(ChronoField.DAY_OF_MONTH));
		
		/**
		 * Modifying LOcal Date
		 */
		System.out.println("Add Days::"+lclDt.plusDays(3));
		System.out.println("Minus Days::"+lclDt.minusDays(3));
		System.out.println("Add Months::"+lclDt.plusMonths(1));
		System.out.println("Minus Months::"+lclDt.minusMonths(1));
		System.out.println("With Year::"+lclDt.withYear(2020));
		System.out.println("Change Year::"+lclDt.with(ChronoField.YEAR,2003));
		System.out.println("Temporal Adjusters::"+lclDt.with(TemporalAdjusters.firstDayOfMonth()));
		System.out.println("Change Year::"+lclDt.minus(1, ChronoUnit.YEARS));
		
		/**
		 * Additional Support by dates
		 */
		System.out.println("Leapyear::"+lclDt.isLeapYear());
		System.out.println("equal::"+lclDt.isEqual(lclDt1));
		System.out.println("after::"+lclDt.isAfter(lclDt1));;
		System.out.println("before::"+lclDt.isBefore(lclDt1));
		
		/**
		 * Unsupported
		 */
//		System.out.println("Not Supported Unit::"+ lclDt.minus(1, ChronoUnit.MINUTES)); // not able to perform minus operation in minutes
		System.out.println("Supported::"+lclDt.isSupported(ChronoField.MINUTE_OF_DAY));
		System.out.println("Supported::"+lclDt.isSupported(ChronoField.YEAR));;
		
		
		
	}
}
