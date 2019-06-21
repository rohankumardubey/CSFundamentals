package org.redquark.features.java8.streams;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class demonstrates the use of the filter and collect function on the
 * list data structure
 * 
 * @author Anirudh Sharma
 */
public class FilterAndCollect {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Declared and initialized the list
		List<String> items = new LinkedList<>();
		
		// Added some items to the list
		items.add("Batman");
		items.add("Superman");
		items.add("Flash");
		items.add("Wonder Woman");
		items.add("Green Lantern");
		items.add("Aquaman");
		
		System.out.println("List before filtering...");
		printList(items);

		// Filtering the list using conventional approach
		System.out.println("\nFiltering the list using conventional approach...");
		List<String> conventionalFilteredList = getFilterOutputUsingConventionalWay(items);
		printList(conventionalFilteredList);

		// Filtering the list using Java 8 way - using filter()
		System.out.println("\nFiltering the list using Java 8 approach...");
		List<String> lambdaFilteredList = getFilteredOutputUsingFilter(items);
		printList(lambdaFilteredList);

	}

	/**
	 * This method will return the filtered output using convention (prior to java
	 * 8) way
	 * 
	 * @param items
	 * @return filtered list
	 */
	private static List<String> getFilterOutputUsingConventionalWay(List<String> items) {

		List<String> filteredOutput = new LinkedList<>();

		for (String item : items) {
			if (!item.equals("Green Lantern")) {
				filteredOutput.add(item);
			}
		}

		return filteredOutput;
	}

	/**
	 * This method will return the filtered list using filter() function
	 * 
	 * @param items
	 * @return filtered list
	 */
	private static List<String> getFilteredOutputUsingFilter(List<String> items) {

		List<String> filteredOutput = items.stream().filter(item -> !item.equals("Flash"))
				.collect(Collectors.toList());

		return filteredOutput;
	}

	/**
	 * This just prints the list items
	 * 
	 * @param items
	 */
	private static void printList(List<String> items) {
		for (String item : items) {
			System.out.println(item);
		}
	}
}
