package org.redquark.collections.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/**
 * @author Anirudh Sharma
 *
 */
public class ArrayListExample {

	public static void main(String[] args) {

		// Creating an ArrayList
		List<String> arrayList = new ArrayList<>();

		// Adding some elements
		arrayList.add("A");
		arrayList.add("B");
		arrayList.add("C");
		arrayList.add("D");
		arrayList.add("E");
		arrayList.add("F");
		arrayList.add("G");
		arrayList.add("H");
		arrayList.add("I");
		arrayList.add("J");

		System.out.println("Original arrayList: " + arrayList);

		// Add elements in the specified position
		arrayList.add(4, "K");
		arrayList.add(7, "L");

		System.out.println("Modified arrayList: " + arrayList);
		
		// Getting element via index
		System.out.print("Accessing ArrayList via index: ");
		arrayList.forEach(i -> System.out.print(i + " "));

		// Remove elements
		arrayList.remove("F");
		arrayList.remove(5);

		System.out.println("\nModified arrayList after removal: " + arrayList);

		// Iteration
		ListIterator<String> listIterator = arrayList.listIterator();
		System.out.print("arrayList iteration: ");
		while (listIterator.hasNext()) {
			System.out.print(listIterator.next() + " ");
		}

		// Convert arrayList to Array
		String[] array = new String[arrayList.size()];
		arrayList.toArray(array);
		System.out.println("\narrayList => Array: " + Arrays.toString(array));

		// Convert Array to arrayList
		List<String> newArrayList = new ArrayList<>(Arrays.asList(array));
		System.out.println("Array to arrayList: " + newArrayList);

		// Sort the arrayList
		Collections.sort(arrayList);
		System.out.println("Sorted arrayList: " + arrayList);

		// Reverse sort the arrayList
		Collections.sort(arrayList, Collections.reverseOrder());
		System.out.println("Reverse sorted arrayList" + arrayList);
	}

}
