package org.redquark.csfundamentals.dswithjava.linkedlists.problems;

import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

public class RemoveDuplicates<T> {

	// Head node of the linked list
	private Node<T> head;

	/**
	 * Constructor
	 */
	public RemoveDuplicates() {
		head = null;
	}

	/**
	 * This method adds a new node at the end of the liked list
	 *
	 * @param item - the data to be stored at the node of the linked list
	 */
	public void add(T item) {
		// If head is null then there is no linked list
		if (head == null) {
			head = new Node<>(item, null);
		} else {
			// Getting reference to the next
			Node<T> node = head;
			// Loop until we get the end of the the linked list
			while (node.next != null) {
				// Move the pointer to the next node
				node = node.next;
			}
			// Created a new node at the end of the linked list
			node.next = new Node<>(item, null);
		}
	}

	/**
	 * This method returns the linked list with unique elements provided that the list is sorted
	 *
	 * @return RemoveDuplicates
	 */
	public RemoveDuplicates<T> removeDuplicatesFromSortedList() {
		// If head is null then there is no list
		if (head == null) {
			return null;
		}
		// Create a new linked list to store the values which are not duplicate
		RemoveDuplicates<T> tempList = new RemoveDuplicates<>();
		// Getting reference to the head node
		Node<T> node = head;
		// Temp node
		Node<T> temp;
		// Added head to the tempList
		tempList.add(head.data);
		// Loop until we reach to the end of the list
		while (node.next != null) {
			if (node.data == node.next.data) {
				// Get pointer to the next node
				temp = node.next.next;
				// Making the next pointer of same node null to remove it
				node.next = null;
				// Point the current node to the next of next node
				node.next = temp;
			} else {
				// Advance if there is no deletion
				node = node.next;
				// Add the distinct node to the tempList
				tempList.add(node.data);
			}
		}
		return tempList;
	}

	/**
	 * This method removes the duplicates from an unsorted linked list
	 *
	 * @return Set
	 */
	public Set<T> removeDuplicatesFromUnsortedList() {
		// If head is null then there is no linked list
		if (head == null) {
			return null;
		}
		// Creating a new HashSet object to store the distinct values
		Set<T> set = new HashSet<>();
		// Get the reference of the head node
		Node<T> current = head;
		// Previous node to current node
		Node<T> previous = null;
		// Loop until we reach the end of the list
		while (current != null) {
			// If node is already present
			if (set.contains(current.data)) {
				// Point the previous of the current node to the next of the current node
				previous.next = current.next;
			} else {
				// If the value is new, add it to the hash set
				set.add(current.data);
				previous = current;
			}
			// Move pointer to one node ahead
			current = current.next;
		}
		return set;
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
		return new RemoveDuplicatesIterator();
	}

	/**
	 * This class represents each node in the linked list
	 *
	 * @param <T>
	 */
	private static class Node<T> {
		// Data to be stored in node of the linked list
		private T data;
		// Pointer to the next node
		private Node<T> next;

		/**
		 * @param data - Data to be stored in the node of the linked list
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
	private class RemoveDuplicatesIterator implements Iterator<T> {

		// Next node
		private Node<T> nextNode;

		/**
		 * Constructor
		 */
		RemoveDuplicatesIterator() {
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
