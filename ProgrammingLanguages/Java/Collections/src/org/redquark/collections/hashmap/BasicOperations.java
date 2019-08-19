package org.redquark.collections.hashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author Anirudh Sharma
 *
 */
public class BasicOperations {

	public static void main(String[] args) {

		Map<Integer, String> comicCharacters = new HashMap<>();

		// Adding values in the map
		addValues(comicCharacters);
		System.out.println("Map after adding values: " + comicCharacters);

		// Getting value based on key
		int key = 7;
		System.out.println("\nValue corresponding to key: " + key + " is: " + getValueByKey(comicCharacters, key));

		// Remove a pair by key
		removePairByKey(comicCharacters, key);
		System.out.println("\nMap afer removing pair corresponding to key: " + key + ": " + comicCharacters);

		// Iterating the map
		iterateHashMap(comicCharacters);

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

	private static String getValueByKey(Map<Integer, String> comicCharacters, Integer key) {
		return comicCharacters.get(key);
	}

	private static void removePairByKey(Map<Integer, String> comicCharacters, Integer key) {
		comicCharacters.remove(key);
	}

	private static void iterateHashMap(Map<Integer, String> comicCharacters) {
		// Less efficient
		System.out.println("\nIterate over keys");
		Iterator<Integer> keyIterator = comicCharacters.keySet().iterator();
		while (keyIterator.hasNext()) {
			Integer key = (Integer) keyIterator.next();
			String value = comicCharacters.get(key);
			System.out.println("Key: " + key + " and Value: " + value);
		}

		// More efficient
		System.out.println("\nIterate over entries set");
		Iterator<Entry<Integer, String>> entryIterator = comicCharacters.entrySet().iterator();
		while (entryIterator.hasNext()) {
			Entry<Integer, String> entry = entryIterator.next();
			Integer key = entry.getKey();
			String value = entry.getValue();
			System.out.println("Key: " + key + " and Value: " + value);
		}
	}
}
