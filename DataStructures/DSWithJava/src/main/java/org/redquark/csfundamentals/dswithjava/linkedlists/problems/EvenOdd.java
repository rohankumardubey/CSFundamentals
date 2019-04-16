package org.redquark.csfundamentals.dswithjava.linkedlists.problems;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class segregates even and odd nodes of a singly linked list
 *
 * @Author Anirudh Sharma
 */
public class EvenOdd {

	// Head of the linked list
	private Node head;

	/**
	 * Constructor
	 */
	public EvenOdd() {
		head = null;
	}

	/**
	 * This method adds a node to the end of the linked list
	 *
	 * @param item - Data to be stored in the newly created node
	 */
	public void add(Integer item) {
		// If head is null, then there is no linked list
		if (head == null) {
			head = new Node(item, null);
		} else {
			// Get reference to the head node
			Node node = head;
			// Loop until we reach the end of the linked list
			while (node.next != null) {
				// Move pointer to the next node
				node = node.next;
			}
			// Create a new node at the end of the linked list
			node.next = new Node(item, null);
		}
	}

	public EvenOdd segregate() {
		// Creating variables for starting and end of even and odd lists
		Node evenStart = null;
		Node evenEnd = null;
		Node oddStart = null;
		Node oddEnd = null;
		// Getting the reference of head node
		Node current = head;
		// Loop until we reach the end of the list
		while (current != null) {
			int item = current.data;
			if ((item % 2) == 0) {
				if (evenStart == null) {
					evenStart = current;
					evenEnd = evenStart;
				} else {
					evenEnd.next = current;
					evenEnd = evenEnd.next;
				}
			} else {
				if (oddStart == null) {
					oddStart = current;
					oddEnd = oddStart;
				} else {
					oddEnd.next = current;
					oddEnd = oddEnd.next;
				}
			}
			current = current.next;
		}
		if (oddStart == null || evenStart == null) {
			return new EvenOdd();
		}
		evenEnd.next = oddStart;
		oddEnd.next = null;
		head = evenStart;

		return this;
	}

	/**
	 * Overridden toString() method
	 *
	 * @return String
	 */
	public String toString() {
		Iterator<Integer> iterator = iterator();
		if (!iterator.hasNext()) {
			return "[]";
		}
		StringBuilder builder = new StringBuilder();
		builder.append('[');
		for (; ; ) {
			int item = iterator.next();
			builder.append(item);
			if (!iterator.hasNext()) {
				return builder.append(']').toString();
			}
			builder.append(", ");
		}
	}

	/**
	 * This method iterates the linked list
	 *
	 * @return Iterator
	 */
	private Iterator<Integer> iterator() {
		return new EvenOddIterator();
	}

	/**
	 * This class represents each node of the linked list
	 */
	private static class Node {
		// Data to be stored in the node
		private Integer data;
		// Next pointer to the node
		private Node next;

		/**
		 * Constructor - this will be called when a node is created
		 *
		 * @param data - Data to be stored in the node
		 * @param next - Next pointer to the node
		 */
		Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	/**
	 * Iterator implementation for this class
	 */
	private class EvenOddIterator implements Iterator<Integer> {

		// Next node
		private Node nextNode;

		/**
		 * Constructor
		 */
		EvenOddIterator() {
			// Setting the nextNode to the reference of head node
			nextNode = head;
		}

		/**
		 * Returns {@code true} if the iteration has more elements.
		 * (In other words, returns {@code true} if {@link #next} would
		 * return an element rather than throwing an exception.)
		 *
		 * @return {@code true} if the iteration has more elements
		 */
		@Override
		public boolean hasNext() {
			// Returns true if the next node is not null
			return nextNode != null;
		}

		/**
		 * Returns the next element in the iteration.
		 *
		 * @return the next element in the iteration
		 * @throws NoSuchElementException if the iteration has no more elements
		 */
		@Override
		public Integer next() {
			// If the next node is null - throw exception
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			// Get the data of the next node
			int data = nextNode.data;
			// Move the pointer to the next node of the nextNode
			nextNode = nextNode.next;
			// Returns the data
			return data;
		}

		/**
		 * Remove the element
		 */
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
}
