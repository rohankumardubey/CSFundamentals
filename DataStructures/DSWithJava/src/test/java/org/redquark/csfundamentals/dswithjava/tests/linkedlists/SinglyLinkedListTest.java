package org.redquark.csfundamentals.dswithjava.tests.linkedlists;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.redquark.csfundamentals.dswithjava.linkedlists.SinglyLinkedList;

import static org.junit.Assert.*;

public class SinglyLinkedListTest<T> {

	// Singly linked list for testing the empty list condition
	private SinglyLinkedList<T> emptyList;

	// Singly linked list for other purposes
	private SinglyLinkedList<String> singlyLinkedList;

	/**
	 * This method sets up the data for the test cases
	 */
	@Before
	public void setUp() {

		// Initializing the empty singly linked list
		emptyList = new SinglyLinkedList<>();
		// Initializing the list
		singlyLinkedList = new SinglyLinkedList<>();

		// Setting up data
		singlyLinkedList.addFirst("Alan Turing");
		singlyLinkedList.addFirst("Tim Berners - Lee");
		singlyLinkedList.addFirst("Edward Snowden");
		singlyLinkedList.addFirst("Linus Torvalds");
		singlyLinkedList.addFirst("Dennis Richie");
		singlyLinkedList.addFirst("James Gosling");
	}

	/**
	 * Tests if the list is empty
	 */
	@Test
	public void testIsEmpty() {
		Assert.assertTrue(emptyList.isEmpty());
	}

	/**
	 * Tests the size of the linked list
	 */
	@Test
	public void testSize() {
		assertEquals(singlyLinkedList.size(), 6);
	}

	/**
	 * Tests the method which adds the new node as the head of the linked list
	 */
	@Test
	public void testAddFirst() {
		// Added a new head
		singlyLinkedList.addFirst("Edsger W. Dijkstra");
		assertEquals(singlyLinkedList.toString(), "[Edsger W. Dijkstra, James Gosling, Dennis Richie, Linus " +
				"Torvalds, Edward Snowden, Tim Berners - Lee, Alan Turing]");
	}

	/**
	 * Tests the method which adds the new node as the last node in the linked list
	 */
	@Test
	public void testAddLast() {
		singlyLinkedList.addLast("David Albert Huffman");
		assertEquals(singlyLinkedList.toString(), "[James Gosling, Dennis Richie, Linus Torvalds, Edward Snowden, Tim Berners - Lee, Alan Turing, David Albert Huffman]");
	}

	/**
	 * Tests the method which returns the first node in the linked list
	 */
	@Test
	public void testGetFirst() {
		assertEquals(singlyLinkedList.getFirst(), "James Gosling");
	}

	/**
	 * Tests the method which returns the last node in the linked list
	 */
	@Test
	public void testGetLast() {
		assertEquals(singlyLinkedList.getLast(), "Alan Turing");
	}

	/**
	 * Tests the method which removes the head of the linked list
	 */
	@Test
	public void testRemoveFirst() {
		assertEquals(singlyLinkedList.removeFirst(), "James Gosling");
	}

	/**
	 * Tests the method which removes the last element of the linked list
	 */
	@Test
	public void testRemoveLast() {
		assertEquals(singlyLinkedList.removeLast(), "Alan Turing");
	}

	/**
	 * Tests the method which checks if a specified element is present in the linked list
	 */
	@Test
	public void testContains() {
		// Item is present
		assertTrue(singlyLinkedList.contains("Edward Snowden"));
		// Item is not present
		assertFalse(singlyLinkedList.contains("Edsger W. Dijkstra"));
	}

	/**
	 * Tests the method which returns the element stored at the passed index
	 */
	@Test
	public void testGet() {
		assertEquals(singlyLinkedList.get(2), "Linus Torvalds");
	}

	/**
	 * Tests the method which removes the node containing the specified data
	 */
	@Test
	public void testRemove() {
		assertEquals(singlyLinkedList.remove("Dennis Richie"), "Dennis Richie");
	}

	/**
	 * Tests the method which inserts a node after the specified node
	 */
	@Test
	public void testInsertAfter() {
		singlyLinkedList.insertAfter("Edward Snowden", "Claude Shannon");
		assertEquals(singlyLinkedList.toString(), "[James Gosling, Dennis Richie, Linus Torvalds, Edward Snowden, Claude Shannon, Tim Berners - Lee, Alan Turing]");
	}

	/**
	 * Tests the method which inserts a node after the specified node
	 */
	@Test
	public void testInsertBefore() {
		singlyLinkedList.insertBefore("Dennis Richie", "Richard Bellman");
		assertEquals(singlyLinkedList.toString(), "[James Gosling, Richard Bellman, Dennis Richie, Linus Torvalds, Edward Snowden, Tim Berners - Lee, Alan Turing]");
	}

	/**
	 * Tests the method which deletes the whole linked list
	 */
	@Test
	public void testClear() {
		Assert.assertNull(singlyLinkedList.clear());
	}

	/**
	 * Tests the method which reverses the linked list
	 */
	@Test
	public void testReverse() {
		// Linked list for storing data in reverse order
		SinglyLinkedList<String> reverseSinglyLinkedList = new SinglyLinkedList<>();

		// Add data
		reverseSinglyLinkedList.addFirst("James Gosling");
		reverseSinglyLinkedList.addFirst("Dennis Richie");
		reverseSinglyLinkedList.addFirst("Linus Torvalds");
		reverseSinglyLinkedList.addFirst("Edward Snowden");
		reverseSinglyLinkedList.addFirst("Tim Berners - Lee");
		reverseSinglyLinkedList.addFirst("Alan Turing");

		assertEquals(singlyLinkedList.reverse().toString(), reverseSinglyLinkedList.toString());
	}

	/**
	 * Tests the method which returns the deep copy of the linked list
	 */
	@Test
	public void testDeepCopy() {
		assertEquals(singlyLinkedList.deepCopy().toString(), singlyLinkedList.toString());
	}
}
