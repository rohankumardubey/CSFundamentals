package org.redquark.features.java8.datetime;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Anirudh Sharma
 *
 */
public class ConvertStringToLocalDate {

	public static void main(String[] args) {

		String date1 = "2019-08-15";
		// Default - ISO_LOCAL_DATE
		LocalDate localDate1 = LocalDate.parse(date1);
		System.out.println(localDate1);

		String date2 = "15-Aug-2019";
		DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("d-MMM-yyyy");
		LocalDate localDate2 = LocalDate.parse(date2, dateTimeFormatter1);
		System.out.println(localDate2);
		System.out.println(dateTimeFormatter1.format(localDate2));

		String date3 = "15/08/2019";
		DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofPattern("d/MM/yyyy");
		LocalDate localDate3 = LocalDate.parse(date3, dateTimeFormatter2);
		System.out.println(localDate3);
		System.out.println(dateTimeFormatter2.format(localDate3));

		String date4 = "Thu, Aug 15 2019";
		DateTimeFormatter dateTimeFormatter3 = DateTimeFormatter.ofPattern("E, MMM d yyyy");
		LocalDate localDate4 = LocalDate.parse(date4, dateTimeFormatter3);
		System.out.println(localDate4);
		System.out.println(dateTimeFormatter3.format(localDate4));

		String date5 = "Thursday, Aug 15, 2019 10:52:34 PM";
		DateTimeFormatter dateTimeFormatter4 = DateTimeFormatter.ofPattern("EEEE, MMM d, yyyy hh:mm:ss a");
		LocalDateTime localDateTime1 = LocalDateTime.parse(date5, dateTimeFormatter4);
		System.out.println(localDateTime1);
		System.out.println(dateTimeFormatter4.format(localDateTime1));

		String date6 = "2019-08-15T11:02:01Z";
		Instant instant1 = Instant.parse(date6);
		System.out.println("Instant: " + instant1);
		// Get date time only
		LocalDateTime localDateTime2 = LocalDateTime.ofInstant(instant1, ZoneId.of(ZoneOffset.UTC.getId()));
		// Get local date
		System.out.println("Local Date: " + localDateTime2.toLocalDate());
		// Get date time + time zone
		ZonedDateTime zonedDateTime1 = instant1.atZone(ZoneId.of("Asia/Kolkata"));
		System.out.println(zonedDateTime1);

		String date7 = "2019-08-15T11:10:43+05:30";
		ZonedDateTime zonedDateTime2 = ZonedDateTime.parse(date7, DateTimeFormatter.ISO_DATE_TIME);
		System.out.println("ZonedDateTime: " + zonedDateTime2);
		System.out.println("TimeZone: " + zonedDateTime2.getZone());
		LocalDate localDate5 = zonedDateTime2.toLocalDate();
		System.out.println("LocalDate: " + localDate5);
	}

}
