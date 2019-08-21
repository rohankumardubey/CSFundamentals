package org.redquark.collections.iterator;

import java.util.LinkedList;
import java.util.List;
import java.util.Spliterator;

/**
 * @author Anirudh Sharma
 *
 */
public class SpliteratorExample {

	public static void main(String[] args) {

		// Creating a list
		List<String> list = new LinkedList<>();

		// Add some elements in the list
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		list.add("E");
		list.add("F");

		// Getting SplitIterator from the list
		Spliterator<String> spliterator = list.spliterator();

		int expected = Spliterator.ORDERED | Spliterator.SIZED | Spliterator.SUBSIZED;

		System.out.println(spliterator.characteristics() == expected); // true

		if (spliterator.hasCharacteristics(Spliterator.ORDERED)) {
			System.out.println("ORDERED");
		}

		if (spliterator.hasCharacteristics(Spliterator.DISTINCT)) {
			System.out.println("DISTINCT");
		}

		if (spliterator.hasCharacteristics(Spliterator.SORTED)) {
			System.out.println("SORTED");
		}

		if (spliterator.hasCharacteristics(Spliterator.SIZED)) {
			System.out.println("SIZED");
		}

		if (spliterator.hasCharacteristics(Spliterator.CONCURRENT)) {
			System.out.println("CONCURRENT");
		}

		if (spliterator.hasCharacteristics(Spliterator.IMMUTABLE)) {
			System.out.println("IMMUTABLE");
		}

		if (spliterator.hasCharacteristics(Spliterator.NONNULL)) {
			System.out.println("NONNULL");
		}

		if (spliterator.hasCharacteristics(Spliterator.SUBSIZED)) {
			System.out.println("SUBSIZED");
		}

		System.out.println("Estimate size: " + spliterator.estimateSize());
		System.out.println("Get exact size if known: " + spliterator.getExactSizeIfKnown());
		
		// Try split
		Spliterator<String> spliterator1 = list.spliterator();
		Spliterator<String> spliterator2 = spliterator.trySplit();
		
		spliterator1.forEachRemaining(System.out::println);
		System.out.println("==========");
		spliterator2.forEachRemaining(System.out::println);
	}

}
