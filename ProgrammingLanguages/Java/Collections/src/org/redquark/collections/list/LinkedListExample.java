package org.redquark.collections.list;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * @author Anirudh Sharma
 *
 */
public class LinkedListExample {

	public static void main(String[] args) {

		// Creating the LinkedList
		List<String> linkedList = new LinkedList<>();

		// Adding some elements
		linkedList.add("A");
		linkedList.add("B");
		linkedList.add("C");
		linkedList.add("D");
		linkedList.add("E");
		linkedList.add("F");
		linkedList.add("G");
		linkedList.add("H");
		linkedList.add("I");
		linkedList.add("J");

		System.out.println("Original LinkedList: " + linkedList);

		// Add elements in the specified position
		linkedList.add(4, "K");
		linkedList.add(7, "L");

		System.out.println("Modified LinkedList: " + linkedList);

		// Remove elements
		linkedList.remove("F");
		linkedList.remove(5);

		System.out.println("Modified LinkedList after removal: " + linkedList);

		// Iteration
		ListIterator<String> listIterator = linkedList.listIterator();
		System.out.print("LinkedList iteration: ");
		while (listIterator.hasNext()) {
			System.out.print(listIterator.next() + " ");
		}

		// Convert LinkedList to Array
		String[] array = new String[linkedList.size()];
		linkedList.toArray(array);
		System.out.println("\nLinkedList => Array: " + Arrays.toString(array));

		// Convert Array to LinkedList
		LinkedList<String> newLinkedList = new LinkedList<>(Arrays.asList(array));
		System.out.println("Array to LinkedList: " + newLinkedList);

		// Sort the LinkedList
		Collections.sort(linkedList);
		System.out.println("Sorted LinkedList: " + linkedList);

		// Reverse sort the LinkedList
		Collections.sort(linkedList, Collections.reverseOrder());
		System.out.println("Reverse sorted LinkedList" + linkedList);
	}

}
