package org.redquark.collections.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Anirudh Sharma
 *
 */
public class MergeHashMaps {

	public static void main(String[] args) {

		// map 1
		Map<Integer, String> map1 = new HashMap<>();

		map1.put(1, "A");
		map1.put(2, "B");
		map1.put(3, "C");
		map1.put(5, "E");

		// map 2
		Map<Integer, String> map2 = new HashMap<>();

		map2.put(1, "G"); // It will replace the value 'A'
		map2.put(2, "B");
		map2.put(3, "C");
		map2.put(4, "D"); // A new pair to be added

		ignoreDuplicateKeys(map1, map2);
		handleDuplicateKeys(map1, map2);
	}

	private static void ignoreDuplicateKeys(Map<Integer, String> map1, Map<Integer, String> map2) {
		// Merge maps
		map1.putAll(map2);
		System.out.println(map1);
	}

	private static void handleDuplicateKeys(Map<Integer, String> map1, Map<Integer, String> map2) {
		map2.forEach((key, value) -> map1.merge(key, value, (v1, v2) -> v1.equalsIgnoreCase(v2) ? v1 : v1 + "," + v2));
		System.out.println(map1);
	}
}
