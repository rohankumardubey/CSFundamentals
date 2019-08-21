package org.redquark.collections.hashmap;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Anirudh Sharma
 *
 */
public class LinkedHashMapExample {

	public static void main(String[] args) {

		Map<Integer, String> pairs = new LinkedHashMap<>();

		// Adding some entries in the LinkedHashMap
		pairs.put(1, "A");
		pairs.put(2, "B");
		pairs.put(3, "C");

		// Getting a value corresponding to the key
		System.out.println("Value corresponding to key: 2 is: " + pairs.get(2));

		// getOrDefault method
		System.out.println("Get default value if key is not present in the map: " + pairs.getOrDefault(4, "Oops!"));
		
		// Iteration with the iterator
		Iterator<Integer> iterator = pairs.keySet().iterator();
		System.out.println("ITerating pairs map");
		while (iterator.hasNext()) {
			Integer key = iterator.next();
			System.out.println("Key: " + key + " and Value: " + pairs.get(key));
		}

		Map<Integer, String> pairsWithAccessOrder = new LinkedHashMap<>(10, 0.75f, true);
		pairsWithAccessOrder.put(1, "A");
		pairsWithAccessOrder.put(2, "B");
		pairsWithAccessOrder.put(3, "C");

		// Access some values
		pairsWithAccessOrder.get(3);
		pairsWithAccessOrder.getOrDefault(2, "Another oops!");

		System.out.println("\nIterating pairsWithAccessOrderMap");
		pairsWithAccessOrder.forEach((k, v) -> {
			System.out.println("Key: " + k + " and Value: " + v);
		});

	}

}
