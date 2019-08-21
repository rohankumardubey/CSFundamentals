package org.redquark.collections.iterator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Anirudh Sharma
 *
 */
public class BasicOperations {

	public static void main(String[] args) {

		// Creating a list
		List<String> list = new LinkedList<>();
		// Adding some values
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");

		// Iterate list
		iterateList(list);

		// Create a set
		Set<String> set = new HashSet<>(list);

		// Iterate set
		iterateSet(set);

		// Creating a map
		Map<Integer, String> map = new HashMap<>();
		// Adding some values
		map.put(1, "A");
		map.put(2, "B");
		map.put(3, "C");
		map.put(4, "D");

		// Iterate map by keys
		iterateMapKeys(map);

		// Iterate map by values
		iterateMapValues(map);

	}

	private static void iterateList(List<String> list) {
		System.out.println("Iterating list: " + list);
		// Get iterator
		Iterator<String> iterator = list.iterator();

		// Traversing the list via iterator
		while (iterator.hasNext()) {
			String value = iterator.next();
			System.out.println(value);

			// Illustrating remove operation
			if (value.equals("C")) {
				iterator.remove();
			}
		}

		System.out.println("Modified list: " + list + "\n");
	}

	private static void iterateSet(Set<String> set) {
		System.out.println("Iterating set: " + set);
		// Get iterator
		Iterator<String> iterator = set.iterator();

		// Traversing the set using iterator
		while (iterator.hasNext()) {
			String value = iterator.next();
			System.out.println(value);

			// Iterating the remove operation
			if (value.equals("D")) {
				iterator.remove();
			}
		}

		System.out.println("Modified set: " + set + "\n");
	}

	private static void iterateMapKeys(Map<Integer, String> map) {
		System.out.println("Iterating map: " + map);
		// Get iterator
		Iterator<Integer> iterator = map.keySet().iterator();

		// Traversing the map using the iterator via keys
		while (iterator.hasNext()) {
			Integer key = iterator.next();
			System.out.println(key);

			// Illustrating the remove operation
			if (key == 2) {
				iterator.remove();
			}
		}

		System.out.println("Modified map: " + map + "\n");
	}

	private static void iterateMapValues(Map<Integer, String> map) {
		System.out.println("Iterating map: " + map);
		// Get iterator
		Iterator<String> iterator = map.values().iterator();

		// Traversing the map using the iterator via values
		while (iterator.hasNext()) {
			String value = iterator.next();
			System.out.println(value);

			// Illustrating the remove operation
			if (value.equals("A")) {
				iterator.remove();
			}
		}

		System.out.println("Modified map: " + map);
	}
}
