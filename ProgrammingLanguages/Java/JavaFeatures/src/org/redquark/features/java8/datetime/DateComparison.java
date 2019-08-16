package org.redquark.features.java8.datetime;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author Anirudh Sharma
 *
 */
public class DateComparison {

	public static void main(String[] args) {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate date1 = LocalDate.of(2019, 8, 16);
		LocalDate date2 = LocalDate.of(2019, 9, 30);

		System.out.println("Date1: " + dtf.format(date1));
		System.out.println("Date2: " + dtf.format(date2));

		if (date1.isAfter(date2)) {
			System.out.println("Date1 is after Date2");
		}

		if (date1.isBefore(date2)) {
			System.out.println("Date1 is before Date2");
		}

		if (date1.isEqual(date2)) {
			System.out.println("Date1 is equal to Date2");
		}
	}

}
