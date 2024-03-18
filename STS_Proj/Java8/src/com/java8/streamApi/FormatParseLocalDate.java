package com.java8.streamApi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FormatParseLocalDate {
	public static void main(String[] args) {
		parseDat();
		formatDat();
	}

	private static void formatDat() {
		// localDate to String
		LocalDate lc = LocalDate.now();
		System.out.println(lc);
		System.out.println(lc.format(DateTimeFormatter.ISO_DATE));
	}

	private static void parseDat() {
		// convert string to localDate
		String dt = "2024-02-18";
		LocalDate lc = LocalDate.parse(dt);
		System.out.println("lc::"+lc);		
		LocalDate lc1 = LocalDate.parse(dt,DateTimeFormatter.ISO_DATE);
		System.out.println("lc1::"+lc1);		
	}
}
