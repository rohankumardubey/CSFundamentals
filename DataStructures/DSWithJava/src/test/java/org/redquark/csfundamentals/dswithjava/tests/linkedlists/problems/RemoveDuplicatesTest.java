package org.redquark.csfundamentals.dswithjava.tests.linkedlists.problems;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.redquark.csfundamentals.dswithjava.linkedlists.problems.RemoveDuplicates;

public class RemoveDuplicatesTest {

	// Getting the reference of RemoveDuplicates
	private RemoveDuplicates<Integer> sortedList, unsortedList;

	@Before
	public void setUp() {
		// Initialize the instance
		sortedList = new RemoveDuplicates<>();
		unsortedList = new RemoveDuplicates<>();
		// Add data to sorted list
		sortedList.add(2);
		sortedList.add(3);
		sortedList.add(3);
		sortedList.add(3);
		sortedList.add(4);
		sortedList.add(4);
		sortedList.add(5);
		sortedList.add(6);
		sortedList.add(7);
		sortedList.add(7);
		sortedList.add(7);
		// Add data to unsorted list
		unsortedList.add(3);
		unsortedList.add(2);
		unsortedList.add(4);
		unsortedList.add(3);
		unsortedList.add(3);
		unsortedList.add(2);
		unsortedList.add(4);
		unsortedList.add(2);
	}

	/**
	 * This method tests the method to remove duplicates in a sorted linked list.
	 */
	@Test
	public void testRemoveDuplicatesFromSortedList() {
		Assert.assertEquals(sortedList.removeDuplicatesFromSortedList().toString(), "[2, 3, 4, 5, 6, 7]");
	}

	/**
	 * This method tests the method to remove duplicates in an unsorted linked list.
	 */
	@Test
	public void testRemoveDuplicatesFromUnsortedList() {
		Assert.assertEquals(unsortedList.removeDuplicatesFromUnsortedList().toString(), "[2, 3, 4]");
	}
}
