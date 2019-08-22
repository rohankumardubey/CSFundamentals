package org.redquark.collections.hashset;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Anirudh Sharma
 *
 */
public class LinkedHashSetExample {

	public static void main(String[] args) {

		// Creating a LinkedHashSet
		Set<String> set = new LinkedHashSet<>();

		// Adding some values
		set.add("A");
		set.add("B");
		set.add("C");
		set.add("D");
		set.add("E");
		set.add("F");

		System.out.println("Original Set: " + set);

		// Check of key exist in the set
		System.out.println("Does C exist in the set? " + set.contains("C"));

		// Removing an element
		set.remove("E");

		System.out.println("Modified Set: " + set);

		// Iterate over values
		Iterator<String> iterator = set.iterator();
		System.out.print("Iterating set: ");
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}

		System.out.println("\nConvert set to array: " + Arrays.toString(set.toArray()));
		System.out.println("Convert set to list: " + set.stream().collect(Collectors.toList()));
	}

}
