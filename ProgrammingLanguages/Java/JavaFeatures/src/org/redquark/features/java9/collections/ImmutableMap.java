package org.redquark.features.java9.collections;

import java.util.Map;

/**
 * @author Anirudh Sharma
 *
 */
public class ImmutableMap {

	public static void main(String[] args) {

		Map<Integer, String> names = Map.ofEntries(Map.entry(1, "Shushruta"), Map.entry(2, "Charaka"),
				Map.entry(3, "Kanad"));
		System.out.println(names);

		try {
			// Updating an immutable map - UnsupportedOperationException
			names.put(2, "Yagvalakya");
		} catch (UnsupportedOperationException e) {
			System.out.println("UnsupportedOperationException occurred");
		}
	}

}
