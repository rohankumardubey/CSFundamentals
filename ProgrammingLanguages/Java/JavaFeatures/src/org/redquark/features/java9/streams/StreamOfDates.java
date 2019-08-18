package org.redquark.features.java9.streams;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Anirudh Sharma
 *
 */
public class StreamOfDates {

	public static void main(String[] args) {
		System.out.println(getDays(LocalDate.now(), LocalDate.now().plusDays(10)));
		System.out.println(getDaysInWeeks(LocalDate.now(), LocalDate.now().plusWeeks(10)));
	}

	private static List<LocalDate> getDays(LocalDate start, LocalDate end) {
		return start.datesUntil(end).collect(Collectors.toList());
	}

	private static List<LocalDate> getDaysInWeeks(LocalDate start, LocalDate end) {
		return start.datesUntil(end, Period.ofWeeks(1)).collect(Collectors.toList());
	}
}
