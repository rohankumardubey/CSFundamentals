package org.redquark.collections.hashmap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
 * @author Anirudh Sharma
 *
 */
public class CompareHashMaps {

	public static void main(String[] args) {

		Map<Integer, String> map1 = new HashMap<>();

		map1.put(1, "A");
		map1.put(2, "B");
		map1.put(3, "C");

		// Same as map1
		Map<Integer, String> map2 = new HashMap<>();

		map2.put(3, "C");
		map2.put(1, "A");
		map2.put(2, "B");

		// Different from map1
		Map<Integer, String> map3 = new HashMap<>();

		map3.put(1, "A");
		map3.put(2, "B");
		map3.put(3, "C");
		map3.put(4, "D");

		// Comparison begins
		compareForSameKeyValues(map1, map2, map3);
		compareForSameKey(map1, map2, map3);
		compareForSameValuesWithoutDuplicates(map1, map2, map3);
		compareForSameValuesWithDuplicates(map1, map2, map3);

	}

	private static void compareForSameKeyValues(Map<Integer, String> map1, Map<Integer, String> map2,
			Map<Integer, String> map3) {
		System.out.println("Is map1 equals map2 for keys and values? " + map1.equals(map2));
		System.out.println("Is map1 equals map3 for keys and values? " + map1.equals(map3));
	}

	private static void compareForSameKey(Map<Integer, String> map1, Map<Integer, String> map2,
			Map<Integer, String> map3) {
		System.out.println("Is map1 equals map2 for keys? " + map1.keySet().equals(map2.keySet()));
		System.out.println("Is map1 equals map3 for keys? " + map1.keySet().equals(map3.keySet()));

		// Check if there are extra keys in HashMaps
		Set<Integer> unionKeys = new HashSet<>(map1.keySet());
		unionKeys.addAll(map2.keySet());
		unionKeys.removeAll(map1.keySet());
		System.out.println("Extra keys in map2 in comparison to map1: " + unionKeys);

		Set<Integer> unionKeysAnother = new HashSet<>(map1.keySet());
		unionKeysAnother.addAll(map3.keySet());
		unionKeysAnother.removeAll(map1.keySet());
		System.out.println("Extra keys in map3 in comparison to map1: " + unionKeysAnother);
	}

	private static void compareForSameValuesWithoutDuplicates(Map<Integer, String> map1, Map<Integer, String> map2,
			Map<Integer, String> map3) {
		System.out.println("Is map1 equals map2 for values without duplicates? "
				+ new LinkedList<>(map1.values()).equals(new LinkedList<>(map2.values())));
		System.out.println("Is map1 equals map3 for values without duplicates? "
				+ new LinkedList<>(map1.values()).equals(new LinkedList<>(map3.values())));
	}

	private static void compareForSameValuesWithDuplicates(Map<Integer, String> map1, Map<Integer, String> map2,
			Map<Integer, String> map3) {
		// Updating value in map3
		map3.put(4, "C");
		System.out.println("Is map1 equals map2 for values with duplicates? "
				+ new HashSet<>(map1.values()).equals(new HashSet<>(map2.values())));
		System.out.println("Is map1 equals map3 for values with duplicates? "
				+ new HashSet<>(map1.values()).equals(new HashSet<>(map3.values())));
	}
}
