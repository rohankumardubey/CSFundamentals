package org.redquark.features.java9.collections;

import java.util.Set;

/**
 * @author Anirudh Sharma
 *
 */
public class ImmutableSet {

	public static void main(String[] args) {

		Set<String> names = Set.of("Shushuta", "Charaka", "Kanad");

		// Elements' order not fixed
		System.out.println(names);

		try {
			// Adding an extra element in the immutable set - UnsupportedOperationException
			names.add("Yagvalakya");
		} catch (UnsupportedOperationException e) {
			System.out.println("UnsupportedOperationException occurred");
		}

		try {
			// Adding a null value in the immutable set - NullPointerException
			Set<String> names2 = Set.of("Shushuta", "Charaka", "Kanad", null);
			System.out.println(names2);
		} catch (NullPointerException e) {
			System.out.println("NullPointerException occurred");
		}

		try {
			// Adding duplicate values in the immutable set - IllegalArgumentException
			Set<String> names3 = Set.of("Shushuta", "Charaka", "Kanad", "Charaka");
			System.out.println(names3);
		} catch (IllegalArgumentException e) {
			System.out.println("IllegalArgumentException occurred");
		}
	}

}
