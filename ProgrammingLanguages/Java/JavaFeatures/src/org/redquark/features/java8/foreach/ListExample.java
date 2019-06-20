package org.redquark.features.java8.foreach;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Anirudh Sharma
 *
 */
public class ListExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Declare and initialize List
		List<String> items = new LinkedList<>();

		// Add some data to the list
		items.add("A");
		items.add("B");
		items.add("C");
		items.add("D");
		items.add("E");

		// Loop through the list normal way
		for (String item : items) {
			System.out.println(item);
		}
		
		System.out.println("********************");

		// Loop through the list using the lambda
		items.forEach(item -> System.out.println(item));

		System.out.println("********************");
		
		// Filter only for specific item
		items.forEach(item -> {
			if ("C".equals(item)) {
				System.out.println(item);
			}
		});

		System.out.println("********************");
		
		// Stream and filter
		items.stream()
			 .filter(item -> item.contains("D"))
			 .forEach(System.out::println);
	}

}
