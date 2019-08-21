package org.redquark.collections.iterator;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * @author Anirudh Sharma
 *
 */
public class ListIteratorExample {

	public static void main(String[] args) {

		// Creating a list
		List<String> list = new ArrayList<>();

		// Adding some elements in the list
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		list.add("E");
		list.add("F");

		// Getting ListIterator
		ListIterator<String> listIterator = list.listIterator();

		System.out.println("Forward direction");

		while (listIterator.hasNext()) {
			System.out.print(listIterator.next() + " ");
		}

		System.out.println("\nBackward direction");

		while (listIterator.hasPrevious()) {
			System.out.print(listIterator.previous() + " ");
		}

		System.out.println("\nIteration from a specified positon");
		listIterator = list.listIterator(2);

		while (listIterator.hasNext()) {
			System.out.print(listIterator.next() + " ");
		}
	}

}
