package org.redquark.features.java10.collections;

import java.util.Map;

/**
 * @author Anirudh Sharma
 *
 */
public class UnmodifiableMap {

	public static void main(String[] args) {

		try {
			Map<Integer, String> map = Map.ofEntries(Map.entry(1, "One"), Map.entry(2, "Two"), Map.entry(3, "Three"));
			Map<Integer, String> mappings = Map.copyOf(map);
			System.out.println(mappings);
			mappings.put(4, "Four");
		} catch (UnsupportedOperationException e) {
			System.out.println("UnsupportedOperationException occurred");
		}
	}

}
