package org.redquark.collections.hashmap;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Anirudh Sharma
 *
 */
public class SortMapByKeys {

	public static void main(String[] args) {

		Map<String, Integer> comicCharacters = new HashMap<>();

		// Adding some values to the map
		addValues(comicCharacters);

		System.out.println("Unsorted Map: " + comicCharacters);
		System.out.println("Sorted Map using TreeMap: " + sortUsingTreeMap(comicCharacters));
		System.out.println("Sorted Map using streams: " + sortUsingStreams(comicCharacters));
	}

	private static void addValues(Map<String, Integer> comicCharacters) {
		comicCharacters.put("Nagraj", 1);
		comicCharacters.put("Super Commando Dhruva", 2);
		comicCharacters.put("Parmanu", 3);
		comicCharacters.put("Doga", 4);
		comicCharacters.put("Shakti", 5);
		comicCharacters.put("Bhokal", 6);
		comicCharacters.put("Anthony", 7);
		comicCharacters.put("Super Indian", 8);
		comicCharacters.put("Tiranga", 9);
		comicCharacters.put("Inspector Steel", 10);
	}

	private static Map<String, Integer> sortUsingTreeMap(Map<String, Integer> comicCharacters) {
		Map<String, Integer> sortedComicCharacters = new TreeMap<>(comicCharacters);
		return sortedComicCharacters;
	}

	private static Map<String, Integer> sortUsingStreams(Map<String, Integer> comicCharacters) {
		Map<String, Integer> sortedComicCharacters = new LinkedHashMap<>();
		comicCharacters.entrySet().stream().sorted(Map.Entry.comparingByKey())
				.forEachOrdered(item -> sortedComicCharacters.put(item.getKey(), item.getValue()));
		return sortedComicCharacters;
	}
}
