package org.redquark.csfundamentals.dswithjava.linkedlists.problems;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SwapNodes<T> {

	// Head node of the linked list
	private Node<T> head;

	/**
	 * Constructor
	 */
	public SwapNodes() {
		head = null;
	}

	/**
	 * This method adds a new node at the end of the linked list
	 *
	 * @param item - data to be stored in the new node
	 */
	public void add(T item) {
		// If head is null then there is no linked list
		if (head == null) {
			// Create the head node which will be the only node in the linked list
			head = new Node<>(item, null);
		} else {
			// Getting reference of the head node
			Node<T> node = head;
			// Loop until we reach the end of the node
			while (node.next != null) {
				// Move one pointer ahead
				node = node.next;
			}
			// Create a new node at the end of the linked list
			node.next = new Node<>(item, null);
		}
	}

	/**
	 * This method swaps the two passed keys
	 *
	 * @param x - First element
	 * @param y - Second element
	 * @return SwapNodes
	 */
	public SwapNodes<T> swapNodes(T x, T y) {
		// If x and y are same then no need to swap
		if (x == y) {
			return null;
		}
		Node<T> previousX = null;
		Node<T> currentX = head;
		// Search for x
		while (currentX != null && currentX.data != x) {
			previousX = currentX;
			currentX = currentX.next;
		}
		// Search for y
		Node<T> previousY = null;
		Node<T> currentY = head;
		// Search for y
		while (currentY != null && currentY.data != y) {
			previousY = currentY;
			currentY = currentY.next;
		}
		// If either x or y is not present, nothing to do
		if (currentX == null || currentY == null) {
			return null;
		}
		// If x is not the head of the linked list
		if (previousX != null) {
			previousX.next = currentY;
		} else {
			head = currentY;
		}
		// If y is not the head of the linked list
		if (previousY != null) {
			previousY.next = currentX;
		} else {
			head = currentX;
		}

		// Swap next pointers
		Node<T> temp = currentX.next;
		currentX.next = currentY.next;
		currentY.next = temp;

		return this;
	}

	/**
	 * This method swaps the adjacent nodes only
	 *
	 * @return SwapNodes
	 */
	public SwapNodes<T> pairwiseSwap() {
		// Getting the reference of the head node
		Node<T> node = head;
		// Loop until only till there are at least 2 nodes left
		while (node != null && node.next != null) {
			// Swap the data
			T data = node.data;
			node.data = node.next.data;
			node.next.data = data;
			node = node.next.next;
		}
		return this;
	}

	/**
	 * Overridden toString() method
	 *
	 * @return String
	 */
	public String toString() {
		Iterator<T> iterator = iterator();
		if (!iterator.hasNext()) {
			return "[]";
		}
		StringBuilder builder = new StringBuilder();
		builder.append('[');
		for (; ; ) {
			T item = iterator.next();
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
	private Iterator<T> iterator() {
		return new SwapNodesIterator();
	}


	/**
	 * This class represents each node in the linked list
	 *
	 * @param <T>
	 */
	private static class Node<T> {
		// Data to be stored in the node
		private T data;
		// Pointer to the next node
		private Node<T> next;

		/**
		 * Constructor - which will be called when a node is created
		 *
		 * @param data - Data to be stored in the node
		 * @param next - Pointer to the next node
		 */
		Node(T data, Node<T> next) {
			this.data = data;
			this.next = next;
		}
	}

	/**
	 * Iterator implementation for this class
	 */
	private class SwapNodesIterator implements Iterator<T> {

		// Next node
		private Node<T> nextNode;

		/**
		 * Constructor
		 */
		SwapNodesIterator() {
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
		public T next() {
			// If the next node is null - throw exception
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			// Get the data of the next node
			T data = nextNode.data;
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
