package org.redquark.features.java10.collections;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * @author Anirudh Sharma
 *
 */
public class UnmodifiableSet {

	public static void main(String[] args) {

		try {
			List<Integer> list = Arrays.asList(1, 2, 3, 4);
			Set<Integer> integers = Set.copyOf(list);
			System.out.println(integers);
			integers.add(5);
		} catch (UnsupportedOperationException e) {
			System.out.println("UnsupportedOperationException occurred");
		}
	}

}
