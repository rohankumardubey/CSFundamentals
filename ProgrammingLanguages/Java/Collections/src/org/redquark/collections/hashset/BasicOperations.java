package org.redquark.collections.hashset;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Anirudh Sharma
 *
 */
public class BasicOperations {

	public static void main(String[] args) {

		// Create a HashSet
		Set<String> set = new HashSet<>();

		// Adding some values
		set.add("A");
		set.add("B");
		set.add("C");
		set.add("D");
		set.add("E");

		System.out.println("Original HashSet: " + set);

		// Adding some duplicate values and new values
		System.out.println("Add D? " + set.add("D"));
		System.out.println("Add B? " + set.add("B"));
		System.out.println("Add F? " + set.add("F"));

		System.out.println("Modified HashSet: " + set);

		// Check if element exists
		System.out.println("Does G exist? " + set.contains("G"));
		System.out.println("Does C exist? " + set.contains("C"));

		// Remove an element
		set.remove("A");
		System.out.println("Set after removing A: " + set);

		// Iterate over values
		Iterator<String> iterator = set.iterator();
		System.out.print("Iterating set: ");
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}

		// Convert HashSet to Array
		System.out.println("\nHashSet to Array: " + Arrays.toString(set.toArray()));

		// HashSet to List
		System.out.println("HashSet to List: " + set.stream().collect(Collectors.toList()));
	}

}
