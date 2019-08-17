package org.redquark.features.java9.collections;

import java.util.List;

/**
 * @author Anirudh Sharma
 *
 */
public class ImmutableList {

	public static void main(String[] args) {

		List<String> names = List.of("Shushuta", "Charaka", "Kanad");

		// Preserve the elements' order
		System.out.println(names);

		try {
			// Adding an extra element in the immutable list - UnsupportedOperationException
			names.add("Yagvalakya");
		} catch (UnsupportedOperationException e) {
			e.printStackTrace();
		}

		try {
			// Adding a null value in the immutable list - NullPointerException
			List<String> names2 = List.of("Shushuta", "Charaka", "Kanad", null);
			System.out.println(names2);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}

}
