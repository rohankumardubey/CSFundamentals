package org.redquark.collections.treemap;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Anirudh Sharma
 *
 */
public class TreeMapExample {

	public static void main(String[] args) {

		// Creating a TreeMap
		Map<Integer, String> treeMap = new TreeMap<>();

		// Adding some values in the TreeMap
		treeMap.put(2, "B");
		treeMap.put(1, "A");
		treeMap.put(3, "C");

		System.out.println("Original TreeMap: " + treeMap);

		// get method
		System.out.println("Value corresponding to key 1 is: " + treeMap.get(1));

		// getOrDefault method
		System.out.println("Depicting getOrDefault method: " + treeMap.getOrDefault(6, "Oops!"));

		// Iteration
		Iterator<Integer> iterator = treeMap.keySet().iterator();
		System.out.print("TreeMap iteration: ");
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}

		// Remove
		treeMap.remove(3);
		System.out.println("\nTreeMap after removing key 3 will be: " + treeMap);
	}

}
