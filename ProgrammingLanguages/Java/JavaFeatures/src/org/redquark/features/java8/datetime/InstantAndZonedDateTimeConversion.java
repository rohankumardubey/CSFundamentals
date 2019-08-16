package org.redquark.features.java8.datetime;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * @author Anirudh Sharma
 *
 */
public class InstantAndZonedDateTimeConversion {

	public static void main(String[] args) {

		Instant instant1 = Instant.now();
		System.out.println("Instant: " + instant1);

		// India time = UTC + 5:30
		ZonedDateTime indiaTime1 = instant1.atZone(ZoneId.of("Asia/Kolkata"));
		System.out.println("ZonedDateTime: " + indiaTime1);
		System.out.println("Offset: " + indiaTime1.getOffset());

		LocalDateTime ldt = LocalDateTime.of(2019, Month.AUGUST, 16, 12, 9, 23);
		// UTC + 5:30
		ZonedDateTime indiaTime2 = ldt.atZone(ZoneId.of("Asia/Kolkata"));
		System.out.println("ZonedDateTime: " + indiaTime2);

		Instant instant2 = indiaTime2.toInstant();
		System.out.println("Instant: " + instant2);
	}

}
