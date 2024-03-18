package com.java8.dates;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class LocalDateTimeExp {
	public static void main(String[] args) {
		LocalDateTime lcl= LocalDateTime.now();
		System.out.println("lcl1::"+lcl);
		
		LocalDateTime lcl1= LocalDateTime.of(1994, 7, 1, 5, 8, 55, 32331);
		System.out.println("lcl1::"+lcl1);
		
		LocalDateTime lcl2= LocalDateTime.of(LocalDate.now(), LocalTime.now());
		System.out.println("lcl2::"+lcl2);
		
		/**
		 * convert date time
		 */
		LocalDate lclDt = LocalDate.of(2004, 2, 2);
		System.out.println("Convert ::"+ lclDt.atTime(12,12));
		
		LocalTime lclTm = LocalTime.of(12, 2);
		System.out.println("Convert:: "+lclTm.atDate(lclDt));
		
		LocalDateTime bothLcl = lclTm.atDate(lclDt);
		System.out.println("extract date::"+bothLcl.toLocalDate());
		System.out.println("extract time::"+bothLcl.toLocalTime());
	}
}
