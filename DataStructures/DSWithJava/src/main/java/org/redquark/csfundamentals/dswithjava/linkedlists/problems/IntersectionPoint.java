package org.redquark.csfundamentals.dswithjava.linkedlists.problems;

/**
 * This class finds the intersection point of two singly linked lists
 *
 * @param <T>
 * @Author Anirudh Sharma
 */
public class IntersectionPoint<T> {

	// Head node of the linked list
	private Node<T> head;

	/**
	 * Constructor
	 */
	public IntersectionPoint() {
		head = null;
	}

	/**
	 * This method adds a new node at the end of the linked list
	 *
	 * @param item - Data to be stored in the node
	 */
	public void add(T item) {
		// If head is null then there is no linked list
		if (head == null) {
			// Create a new node which will be the head of the linked list
			head = new Node<>(item, null);
		} else {
			// Get reference of the head node
			Node<T> node = head;
			// Loop until we reach the end of the linked list
			while (node.next != null) {
				// Move the pointer to the next node
				node = node.next;
			}
			node.next = new Node<>(item, null);
		}
	}

	/**
	 * This method returns the intersection point of two linked lists
	 *
	 * @param firstList  - first linked list
	 * @param secondList - second linked list
	 * @return T
	 */
	public T findIntersectionPoint(IntersectionPoint<T> firstList, IntersectionPoint<T> secondList) {
		// Getting the head refereces of both linked lists
		Node<T> firstListHead = firstList.head;
		Node<T> secondListHead = secondList.head;
		// If head of either of the linked lists are null then there will be no intersection point
		if (firstListHead == null || secondListHead == null) {
			return null;
		}
		// Counters for the length of both linked lists
		int c1 = 0, c2 = 0;
		// Find the length of the first linked list
		while (firstListHead != null) {
			c1++;
			firstListHead = firstListHead.next;
		}
		// Find the length of the second linked list
		while (secondListHead != null) {
			c2++;
			secondListHead = secondListHead.next;
		}
		// Find the difference of two counters
		int d = Math.abs(c1 - c2);
		// Reference node
		Node<T> reference;
		// Current node pointers for both lists
		Node<T> firstCurrent, secondCurrent;
		// Loop until d
		if (c1 > c2) {
			reference = firstList.head;
			for (int i = 1; i < d; i++) {
				reference = reference.next;
			}
			firstCurrent = reference;
			secondCurrent = secondList.head;
		} else {
			reference = secondList.head;
			for (int i = 1; i < d; i++) {
				reference = reference.next;
			}
			secondCurrent = reference;
			firstCurrent = firstList.head;
		}
		// Loop each list until we reach the end of the list or to the intersection point
		while (firstCurrent != null && secondCurrent != null) {
			if (firstCurrent.data == secondCurrent.data) {
				return firstCurrent.data;
			}
			firstCurrent = firstCurrent.next;
			secondCurrent = secondCurrent.next;
		}
		return null;
	}

	/**
	 * This class represents each node in the linked list
	 *
	 * @param <T>
	 */
	private static class Node<T> {
		// Data to be stored in the linked list
		private T data;
		// Next pointer of the node
		private Node<T> next;

		/**
		 * Constructor - this will be called when a node is created in the linked list
		 *
		 * @param data - Data to be stored in the linked list
		 * @param next - Next pointer of the node
		 */
		Node(T data, Node<T> next) {
			this.data = data;
			this.next = next;
		}
	}
}
