package org.redquark.collections.hashmap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Anirudh Sharma
 *
 */
public class SortMapByValues {

	public static void main(String[] args) {

		Map<Integer, String> comicCharacters = new HashMap<>();

		// Adding some values to the map
		addValues(comicCharacters);

		System.out.println("Unsorted Map: " + comicCharacters);
		System.out.println("Sorted Map: " + sortUsingStreams(comicCharacters));
		System.out.println("Reverse sorted Map: " + reverseSortUsingStreams(comicCharacters));
	}

	private static void addValues(Map<Integer, String> comicCharacters) {
		comicCharacters.put(1, "Nagraj");
		comicCharacters.put(2, "Super Commando Dhruva");
		comicCharacters.put(3, "Parmanu");
		comicCharacters.put(4, "Doga");
		comicCharacters.put(5, "Shakti");
		comicCharacters.put(6, "Bhokal");
		comicCharacters.put(7, "Anthony");
		comicCharacters.put(8, "Super Indian");
		comicCharacters.put(9, "Tiranga");
		comicCharacters.put(10, "Inspector Steel");
	}

	private static Map<Integer, String> sortUsingStreams(Map<Integer, String> comicCharacters) {
		Map<Integer, String> sortedComicCharacters = new LinkedHashMap<>();
		comicCharacters.entrySet().stream().sorted(Map.Entry.comparingByValue())
				.forEachOrdered(item -> sortedComicCharacters.put(item.getKey(), item.getValue()));
		return sortedComicCharacters;
	}

	private static Map<Integer, String> reverseSortUsingStreams(Map<Integer, String> comicCharacters) {
		Map<Integer, String> reverseSortedComicCharacters = new LinkedHashMap<>();
		comicCharacters.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.forEachOrdered(item -> reverseSortedComicCharacters.put(item.getKey(), item.getValue()));
		return reverseSortedComicCharacters;
	}
}
