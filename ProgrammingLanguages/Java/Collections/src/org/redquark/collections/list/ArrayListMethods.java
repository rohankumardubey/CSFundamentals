package org.redquark.collections.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * @author Anirudh Sharma
 *
 */
public class ArrayListMethods {

	public static void main(String[] args) {

		// Creating an ArrayList
		List<String> names = new ArrayList<>();

		// Adding some elements in the list
		names.add("Alex");
		names.add("Brian");
		names.add("Charles");

		System.out.println("ArrayList: " + names);

		// Creating a new ArrayList
		List<String> surnames = new ArrayList<>();

		// Adding some elements in the list
		surnames.add("Ferguson");
		surnames.add("Goetz");
		surnames.add("Harper");

		// Append surnames to names list
		names.addAll(surnames);

		System.out.println("Modfied names list: " + names);

		// Adding elements from a certain index
		names.removeAll(surnames);
		names.addAll(1, surnames);

		System.out.println("Modified list from an index: " + names);

		// Clear an ArrayList = surnames
		surnames.clear();
		System.out.println("Surnames after clearing: " + surnames);

		// Create shallow copy of an ArrayList
		ArrayList<String> namesShallowClone = new ArrayList<>(names);

		System.out.println("Clone (shallow copy) of names list: " + namesShallowClone);

		// Create deep copy of ArrayList
		ArrayList<String> namesDeepClone = new ArrayList<>();

		Iterator<String> iterator = names.iterator();

		while (iterator.hasNext()) {
			namesDeepClone.add(iterator.next());
		}

		System.out.println("Clone (deep copy) of names list: " + namesDeepClone);

		// Check if an element exist in the list
		System.out.println("Does Alex present in the names list? " + names.contains("Alex"));
		System.out.println("Does Alex present in the names list? " + names.contains("Lucas"));

		// Check the index of an element in the list
		System.out.println("Index of Alex: " + names.indexOf("Alex"));
		System.out.println("Index of Lucas: " + names.indexOf("Lucas"));

		// For each
		System.out.print("ForEach: ");
		names.forEach(name -> System.out.print(name + "|"));

		// List Iterator
		ListIterator<String> listIterator = names.listIterator();
		System.out.print("\nFORWARD: ");
		while (listIterator.hasNext()) {
			System.out.print(listIterator.next() + "|");
		}

		System.out.print("\nBACKWARD: ");
		while (listIterator.hasPrevious()) {
			System.out.print(listIterator.previous() + "|");
		}
	}

}
