package org.redquark.csfundamentals.dswithjava.linkedlists.problems;

import java.util.NoSuchElementException;

/**
 * @Author Anirudh Sharma
 * <p>
 * This class will show the method to find the middle element in a linked list
 */
public class FindMiddleElement<T> {

	private Node<T> head;

	public FindMiddleElement() {
		head = null;
	}

	/**
	 * This method will find the middle element of the node
	 *
	 * @return T
	 */
	public T findMiddle() {
		// If head is null then there is no linked list
		if (head == null) {
			throw new NoSuchElementException();
		}

		// Slower pointer
		Node<T> slower = head;
		// Faster pointer
		Node<T> faster = head;

		// Iterate until both slower and faster pointer are null
		while (faster != null && faster.next != null) {
			// Move slower pointer to the next node (jumping 1)
			slower = slower.next;
			// Move faster pointer to the node after the next (Jumping 2)
			faster = faster.next.next;
		}
		return slower.data;
	}

	/**
	 * This method will add a new data to the end of the linked list
	 *
	 * @param item - data to be stored in the linked list
	 */
	public void add(T item) {
		if (head == null) {
			head = new Node<>(item, null);
		} else {
			// Getting the reference of the head node
			Node<T> node = head;
			// Iterate until we reach the end of the linked list
			while (node.next != null) {
				node = node.next;
			}
			// Adding a node to the end of the linked list
			node.next = new Node<>(item, null);
		}
	}

	/**
	 * This static inner class will represent each node of the linked list
	 *
	 * @param <T>
	 */
	private static class Node<T> {

		// Data to be stored in the linked list
		private T data;

		// Next pointer of the node
		private Node<T> next;

		/**
		 * Constructor - This will be called when a new node is created for the linked list
		 *
		 * @param data - data to be stored in the node
		 * @param next - next pointer of the node
		 */
		Node(T data, Node<T> next) {
			this.data = data;
			this.next = next;
		}
	}
}
