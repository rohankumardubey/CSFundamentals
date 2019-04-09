package org.redquark.csfundamentals.dswithjava.linkedlists.problems;

/**
 * @param <T>
 * @Author Anirudh Sharma
 */
public class Palindrome<T> {

	// Head node of the linked list
	private Node<T> head;
	private Node<T> slower;
	private Node<T> middle;

	/**
	 * Constructor
	 */
	public Palindrome() {
		head = null;
	}

	public void add(T item) {
		// If head is null then there is no linked list
		if (head == null) {
			// Create the head node which will be the only node in the linked list
			head = new Node<>(item, null);
		} else {
			// Get the reference of the head
			Node<T> node = head;
			// Loop until we reach the end of the linked list
			while (node.next != null) {
				// Move node pointer one position ahead
				node = node.next;
			}
			// Create a new node at the end of the linked list
			node.next = new Node<>(item, null);
		}
	}

	/**
	 * This method returns true if a linked list is palindrome, false otherwise.
	 * STEPS-
	 * 1. Find the middle of the linked list
	 * 2. Reverse the second half of the list
	 * 3. Compare both halves
	 * 4. Reverse the second half again and attach it to the first half
	 *
	 * @return boolean
	 */
	public boolean checkPalindrome() {
		// Flag to check if the list is palindrome or not
		boolean flag = false;
		/*
		  Step 1: Find the middle of the linked list
		 */
		// Getting two pointers - faster and slower
		slower = head;
		Node<T> faster = head;
		// Iterate until we reach the end of the linked list
		while (slower != null && faster != null && faster.next != null) {
			// Move slower pointer only one position ahead
			slower = slower.next;
			// Move faster pointer two positions ahead
			faster = faster.next.next;
		}
		/*
		  Step 2: Reverse the second half of the linked list
		*/
		reverse();
		/*
		  Step 3: Compare both halves (first half and reversed second half)
		 */
		// Create a temp node which will point to the head of the first half
		Node<T> first = head;
		while (middle != null) {
			if (first.data == middle.data) {
				flag = true;
				middle = middle.next;
				first = first.next;
			} else {
				return false;
			}
		}
		/*
		  Step 4: Reverse the second half and attach it to the end of the first half
		 */
		// Reverse the second half again
		reverse();
		Node<T> previous = head;
		if (middle != null) {
			previous.next = middle;
			middle.next = slower;
		} else {
			previous.next = slower;
		}
		return flag;
	}

	private void reverse() {
		// Getting the reference of the first node of the second half
		middle = slower;
		// Previous node
		Node<T> previous = null;
		// Next node
		Node<T> next;
		// Loop until we reach the end of the second half of the linked list
		while (middle != null) {
			next = middle.next;
			middle.next = previous;
			previous = middle;
			middle = next;
		}
		middle = previous;
	}

	/**
	 * This class represents each node of the singly linked list
	 *
	 * @param <T>
	 */
	private static class Node<T> {
		// Data to be stored in the node
		private T data;
		// Pointer to the next node
		private Node<T> next;

		/**
		 * Constructor to create node of the linked list
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
