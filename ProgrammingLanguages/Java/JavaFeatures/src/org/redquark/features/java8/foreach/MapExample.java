package org.redquark.features.java8.foreach;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Anirudh Sharma
 *
 */
public class MapExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Declare and initialize map
		Map<String, Integer> countMap = new HashMap<>();

		// Add some data to the map
		countMap.put("A", 10);
		countMap.put("B", 20);
		countMap.put("C", 30);
		countMap.put("D", 40);
		countMap.put("E", 50);
		countMap.put("F", 60);

		// Loop through map normal way
		System.out.println("Loop through map normal way...");
		for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
			System.out.println("Item: " + entry.getKey() + " => Count: " + entry.getValue());
		}

		System.out.println("\nLoop through map using lambda");
		// Loop through map using lambda
		countMap.forEach((k, v) -> System.out.println("Item: " + k + " => Count: " + v));
	}

}
