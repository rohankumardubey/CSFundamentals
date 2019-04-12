package org.redquark.csfundamentals.dswithjava.linkedlists.problems;

import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

/**
 * @param <T>
 * @Author Anirudh Sharma
 */
public class UnionAndIntersection<T> {

	// Head node of the linked list
	private Node<T> head;

	public UnionAndIntersection() {
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
	 * This method returns the union of two lists
	 *
	 * @param firstList  - First list
	 * @param secondList - Second list
	 * @return UnionAndIntersection
	 */
	public UnionAndIntersection union(UnionAndIntersection<T> firstList, UnionAndIntersection<T> secondList) {
		// If either of the list is null then return the other list
		if (firstList.head == null) {
			return secondList;
		}
		if (secondList.head == null) {
			return firstList;
		}
		// Creating a HashTable
		Set<T> set = new HashSet<>();
		// Create a new list for the union of two lists
		UnionAndIntersection<T> unionList = new UnionAndIntersection<>();
		// Get the head of first list
		Node<T> firstListHead = firstList.head;
		// Add all the elements of the first list
		while (firstListHead != null) {
			unionList.add(firstListHead.data);
			set.add(firstListHead.data);
			firstListHead = firstListHead.next;
		}
		// Getting head of second list
		Node<T> secondListHead = secondList.head;
		// Add only the distinct elements from the second list into the unionList
		while (secondListHead != null) {
			if (!set.contains(secondListHead.data)) {
				unionList.add(secondListHead.data);
				set.add(secondListHead.data);
			}
			secondListHead = secondListHead.next;
		}
		return unionList;
	}

	public UnionAndIntersection<T> intersection(UnionAndIntersection<T> firstList, UnionAndIntersection<T> secondList) {
		// Create a new intersection list
		UnionAndIntersection<T> intersectionList = new UnionAndIntersection<>();
		// If either of the list is null then return empty list
		if (firstList.head == null || secondList.head == null) {
			return intersectionList;
		}
		// Getting the head of the first list
		Node<T> firstListHead = firstList.head;
		// Getting the head of the second list
		Node<T> secondListHead = secondList.head;
		// Creating a set of nodes in linked lists
		Set<T> set = new HashSet<>();
		// Added all the elements of the first list to the set
		while (firstListHead != null) {
			set.add(firstListHead.data);
			firstListHead = firstListHead.next;
		}
		// Loop through the second list and add common elemts to the new list
		while (secondListHead != null) {
			if (set.contains(secondListHead.data)) {
				set.add(secondListHead.data);
				intersectionList.add(secondListHead.data);
			}
			secondListHead = secondListHead.next;
		}
		return intersectionList;
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
		return new UnionAndIntersectionIterator();
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
		 * Constructor - this will be called when a new node is created
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
	private class UnionAndIntersectionIterator implements Iterator<T> {

		// Next node
		private Node<T> nextNode;

		/**
		 * Constructor
		 */
		UnionAndIntersectionIterator() {
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
