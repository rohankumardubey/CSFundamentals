package org.redquark.csfundamentals.dswithjava.linkedlists.problems;

import java.util.NoSuchElementException;

/**
 * This class demonstrates the methods of finding the Nth node from the start and end of a lin
 *
 * @param <T>
 * @Author Anirudh Sharma
 */
public class FindNthNode<T> {

	// Head node of the linked list
	private Node<T> head;

	/**
	 * Constructor
	 */
	public FindNthNode() {
		head = null;
	}

	public void add(T item) {
		// If head is null then there is no linked list
		if (head == null) {
			// Head will be the only node in the linked list
			head = new Node<>(item, null);
		} else {
			// Get the reference of the head node
			Node<T> node = head;
			// Loop until we reach the end of the linked list
			while (node.next != null) {
				// Move the next pointer one place ahead
				node = node.next;
			}
			// Create a new node at the end of the linked list
			node.next = new Node<>(item, null);
		}
	}

	/**
	 * This method will return the data stored in the Nth node from the start
	 *
	 * @param n - Nth node
	 * @return T
	 */
	public T fromStart(int n) {
		// Getting the reference of head node
		Node<T> node = head;
		// Counter
		int count = 1;
		// Loop until we encounter end of the linked list
		while (node != null) {
			// If the count is equal to the n, then we return the data in the node
			if (count == n) {
				return node.data;
			}
			// Move pointer to the next node
			node = node.next;
			// Increment the counter
			count++;
		}
		throw new NoSuchElementException();
	}

	/**
	 * This method returns the Nth node from the end of the linked list
	 *
	 * @param n - Nth node from the end
	 * @return T
	 */
	public T fromEnd(int n) {
		// Getting the reference of the head node
		Node<T> ahead = head;
		for (int i = 0; i < n; i++) {
			ahead = ahead.next;
		}
		Node<T> behind = head;
		while (ahead != null) {
			ahead = ahead.next;
			behind = behind.next;
		}
		return behind.data;
	}

	/**
	 * This class represents each node of the linked list
	 *
	 * @param <T>
	 */
	private static class Node<T> {
		// Data to be stored in the node
		private T data;
		// Next pointer of the node
		private Node<T> next;

		/**
		 * @param data - data to be stored in the node
		 * @param next - next pointer of the node
		 */
		Node(T data, Node<T> next) {
			this.data = data;
			this.next = next;
		}
	}
}
