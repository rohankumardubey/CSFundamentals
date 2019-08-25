package org.redquark.collections.hashset;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author Anirudh Sharma
 *
 */
public class CopyOnWriteArraySetExample {

	public static void main(String[] args) {
		
		// Create a CopyOnWriteArraySet
		Set<Integer> cowas = new CopyOnWriteArraySet<>(Arrays.asList(1, 2, 3));
		System.out.println("Original set: " + cowas);
		
		// Get Iterator 1
		Iterator<Integer> iteratorOne = cowas.iterator();
		
		// Add one more element and verify if the set is updated
		cowas.add(4);
		System.out.println("Modified set: " + cowas);
		
		// Get Iterator 2
		Iterator<Integer> iteratorTwo = cowas.iterator();
		
		System.out.println("-----< Iterator 1 content >-----");
		iteratorOne.forEachRemaining(System.out::println);

		System.out.println("-----< Iterator 2 content >-----");
		iteratorTwo.forEachRemaining(System.out::println);
	}

}
