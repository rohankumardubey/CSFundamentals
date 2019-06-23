package org.redquark.features.java8.streams;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Anirudh Sharma
 *
 */
public class GroupingBy {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Getting the list of fruits
		List<String> fruits = addData();

		// Display total count of fruits in the list
		System.out.println("Count: " + groupByList(fruits));

		// Display the total count of fruits in descending order
		System.out.println("Sorted by count: " + sortByCountInDescendingOrder(groupByList(fruits)));
	}

	/**
	 * This method creates a list of fruits
	 * 
	 * @return {@link List}
	 */
	private static List<String> addData() {

		List<String> fruits = Arrays.asList("Apple", "Apple", "Banana", "Apple", "Mango", "Orange", "Banana", "Orange",
				"Apple", "Banana", "Banana", "Mango", "Apple", "Orange");

		return fruits;
	}

	/**
	 * This method returns the map of fruits grouped by their count
	 * 
	 * @param fruits
	 * @return {@link Map}
	 */
	private static Map<String, Long> groupByList(List<String> fruits) {

		Map<String, Long> fruitCount = fruits.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		return fruitCount;
	}

	/**
	 * This method returns a map sorted by values in the descending order
	 * 
	 * @param fruitCount
	 * @return {@link Map}
	 */
	private static Map<String, Long> sortByCountInDescendingOrder(Map<String, Long> fruitCount) {

		Map<String, Long> sortedFruitMap = new LinkedHashMap<>();

		// Sort the map and add to the sortedFruitMap
		fruitCount.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed())
				.forEachOrdered(fruit -> sortedFruitMap.put(fruit.getKey(), fruit.getValue()));

		return sortedFruitMap;
	}

}
