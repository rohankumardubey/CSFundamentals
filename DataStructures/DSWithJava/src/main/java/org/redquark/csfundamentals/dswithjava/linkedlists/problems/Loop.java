package org.redquark.csfundamentals.dswithjava.linkedlists.problems;

import java.util.NoSuchElementException;

/**
 * This class deals with finding the loop, deleting the loop and finding the length of the loop in a linked list
 *
 * @Author Anirudh Sharma
 */
public class Loop<T> {

	// Head of the linked list
	public Node<T> head;

	// Slower pointer - this will jump only one position at a time
	private Node<T> slower;

	// Flag to determine if the cycle exists in the linked list
	private boolean flag;

	/**
	 * Constructor
	 */
	public Loop() {
		head = null;
	}

	/**
	 * This method will add a new node at the end of the linked list
	 *
	 * @param item - data to be stored in the node of the linked list
	 */
	public void add(T item) {
		// If head is null then there is no linked list.
		if (head == null) {
			// Create a new node in the linked list and it will be the head.
			head = new Node<>(item, null);
		} else {
			// Getting reference of the next node
			Node<T> node = head;
			// Iterating until we reach the end of the linked list
			while (node.next != null) {
				node = node.next;
			}
			// Creating a new node and adding it to the end of the linked list
			node.next = new Node<>(item, null);
		}
	}

	/**
	 * This method returns true if there is loop in the linked list, false otherwise
	 *
	 * @return java.lang.Boolean
	 */
	public boolean detectLoop() {
		// If head is null then there is no linked list
		if (head == null) {
			throw new NoSuchElementException();
		}
		// Creating slow pointer
		slower = head;
		// Creating fast pointer
		Node<T> faster = head;
		//Iterating loop
		while (slower != null && faster != null && faster.next != null) {
			// Jump slower pointer 1 position
			slower = slower.next;
			// Jump faster pointer two positions
			faster = faster.next.next;
			// If there is loop then slower and faster pointer will be equal at some time
			if (slower == faster) {
				flag = true;
				return true;
			}
		}
		return false;
	}

	/**
	 * This method returns the length of the cycle in the linked list
	 *
	 * @return int
	 */
	public int loopLength() {
		// Counter
		int count = 1;
		// Execute only if there is loop in the linked list
		if (flag) {
			// Getting reference of the slower node
			Node node = slower;
			// Loop until the reference is not equal to the slower node after advancing the reference one pointer
			while (node.next != slower) {
				// Moving forward in the cycle
				node = node.next;
				// Increment the count
				count++;
			}
		}
		return count;
	}

	/**
	 * This method removes the cycle in the linked list
	 */
	public void removeLoop() {
		// Get the length of the cycle in the linked list
		int count = loopLength();
		// Setting two temp pointers to head
		Node<T> temp1 = head;
		Node<T> temp2 = head;

		// Advance one pointer equal to the length of the loop
		for (int i = 0; i < count; i++) {
			temp2 = temp2.next;
		}

		// Move both pointers with same pace.
		// They will meet at the loop starting point
		while (temp1 != temp2) {
			temp1 = temp1.next;
			temp2 = temp2.next;
		}

		// Get pointer to the last node
		temp2 = temp2.next;
		while (temp2.next != temp1) {
			temp2 = temp2.next;
		}
		// To remove cycle, set the pointer to null
		temp2.next = null;
	}


	/**
	 * This class represents a single node in the linked list
	 *
	 * @param <T>
	 */
	public static class Node<T> {
		// Pointer to the next node
		public Node<T> next;
		// Data to be stored in the node
		private T data;

		/**
		 * This constructor will create a new node
		 *
		 * @param data - data to be stored in the node
		 * @param next - pointer to the next node
		 */
		Node(T data, Node<T> next) {
			this.data = data;
			this.next = next;
		}
	}
}
