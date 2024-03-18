package com.java8.dates;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ZonedDateTimeExp {
	public static void main(String[] args) {
		ZonedDateTime zst = ZonedDateTime.now();
		System.out.println(zst);
		System.out.println(zst.getZone());
		System.out.println(zst.getOffset());
		
		/**
		 * Convert localdatetime to zone
		 */
		LocalDateTime lt  = LocalDateTime.now();
		System.out.println(lt.atZone(ZoneId.of("Asia/Calcutta")));
	}
}
