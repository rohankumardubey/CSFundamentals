package org.redquark.collections.list;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Anirudh Sharma
 *
 */
public class CopyOnWriteArrayListExample {

	public static void main(String[] args) {

		// Creating CopyOnWriteArrayList and adding elements
		List<Integer> cowal = new CopyOnWriteArrayList<>(new Integer[] { 1, 2, 3 });
		System.out.println("Original list: " + cowal);

		// Iterator 1
		Iterator<Integer> iteratorOne = cowal.iterator();

		// Add one more elements and verify if the list is updated
		cowal.add(4);
		System.out.println("Updated list: " + cowal);

		// Get iterator 2
		Iterator<Integer> iteratorTwo = cowal.iterator();

		System.out.println("-----< Iterator 1 content >-----");
		iteratorOne.forEachRemaining(System.out::println);

		System.out.println("-----< Iterator 2 content >-----");
		iteratorTwo.forEachRemaining(System.out::println);

	}

}
