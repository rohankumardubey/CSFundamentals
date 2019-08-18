package org.redquark.features.java10.collections;

import java.util.Arrays;
import java.util.List;

/**
 * @author Anirudh Sharma
 *
 */
public class UnmodifiableList {

	public static void main(String[] args) {

		try {
			List<Integer> list = Arrays.asList(1, 2, 3, 4);
			List<Integer> integers = List.copyOf(list);
			System.out.println(integers);
			integers.add(5);
		} catch (UnsupportedOperationException e) {
			System.out.println("UnsupportedOperationException occurred");
		}
	}

}
