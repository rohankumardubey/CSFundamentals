package org.redquark.collections.treemap;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Anirudh Sharma
 *
 */
public class ReverseOrdering {

	public static void main(String[] args) {

		// Creating a TreeMap
		Map<Integer, String> reverseTreeMap = new TreeMap<>(Collections.reverseOrder());

		// Adding some values
		reverseTreeMap.put(2, "B");
		reverseTreeMap.put(3, "C");
		reverseTreeMap.put(1, "A");

		System.out.println("Reverse TreeMap: " + reverseTreeMap);
	}

}
