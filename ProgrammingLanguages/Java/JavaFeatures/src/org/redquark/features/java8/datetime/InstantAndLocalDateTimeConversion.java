package org.redquark.features.java8.datetime;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneOffset;

/**
 * @author Anirudh Sharma
 *
 */
public class InstantAndLocalDateTimeConversion {

	public static void main(String[] args) {

		Instant instant1 = Instant.now();
		System.out.println("Instant: " + instant1);

		// Convert Instant to LocalDateTime, no time zone, add a zero offset / UTC+0
		LocalDateTime localDateTime1 = LocalDateTime.ofInstant(instant1, ZoneOffset.UTC);
		System.out.println("Local Date Time: " + localDateTime1);

		// Hard code a date time
		LocalDateTime localDateTime2 = LocalDateTime.of(2019, Month.AUGUST, 16, 11, 49, 45);
		System.out.println("Local Date Time: " + localDateTime2);

		// Convert LocalDateTime to Instant, UTC+0
		Instant instant2 = localDateTime2.toInstant(ZoneOffset.UTC);
		System.out.println("Instant: " + instant2);
	}

}
