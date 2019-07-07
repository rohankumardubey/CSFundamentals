package org.redquark.features.java8.maps;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Anirudh Sharma
 *
 */
public class SortAMap {

	/**
	 * Steps to sort a Map in Java 8.
	 * 
	 * 1. Convert a Map into a Stream 
	 * 2. Sort it 
	 * 3. Collect and return a new LinkedHashMap (keep the order)
	 */

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Map<String, Integer> unsortedMap = new HashMap<>();

		// Add some data to the map
		unsortedMap = addData(unsortedMap);

		// Sort map by keys
		Map<String, Integer> keySortedMap = sortMapByKeys(unsortedMap);
		System.out.println("Key Sorted Map: " + keySortedMap);

		// Sort map by values
		Map<String, Integer> valueSortedMap = sortMapByValues(unsortedMap);
		System.out.println("Value Sorted Map: " + valueSortedMap);
	}

	private static Map<String, Integer> addData(Map<String, Integer> data) {
		data.put("z", 10);
		data.put("b", 5);
		data.put("a", 6);
		data.put("c", 20);
		data.put("d", 1);
		data.put("e", 7);
		data.put("y", 8);
		data.put("n", 99);
		data.put("g", 50);
		data.put("m", 2);
		data.put("f", 9);

		return data;
	}

	private static Map<String, Integer> sortMapByKeys(Map<String, Integer> unsortedMap) {

		/**
		 * Sort by keys, a,b,c, ... and return a new LinkedHashMap. The method toMap()
		 * will return HashMap by default, we need LinkedHashMap to keep the order
		 */
		Map<String, Integer> sortedMap = unsortedMap.entrySet().stream().sorted(Map.Entry.comparingByKey())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue,
						LinkedHashMap::new));

		return sortedMap;
	}

	private static Map<String, Integer> sortMapByValues(Map<String, Integer> unsortedMap) {

		/**
		 * Sort by values, and reserve it, 10,9,8,7,6...
		 */
		Map<String, Integer> sortedMap = unsortedMap.entrySet().stream().sorted(Map.Entry.comparingByValue())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue,
						LinkedHashMap::new));

		return sortedMap;
	}

}
