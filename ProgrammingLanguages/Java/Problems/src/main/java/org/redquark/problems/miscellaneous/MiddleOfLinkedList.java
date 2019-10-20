package org.redquark.problems.miscellaneous;

/**
 * @author Anirudh Sharma
 *
 */
public class MiddleOfLinkedList {

	// Head of the linked list
	private static Node head;

	private static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	/**
	 * Inserts a new Node at front of the list.
	 */
	public static void push(int new_data) {

		// 1 & 2: Allocate the Node & Put in the data
		Node newNode = new Node(new_data);

		// 3. Make next of new Node as head
		newNode.next = head;

		// 4. Move the head to point to new Node
		head = newNode;
	}

	/**
	 * This function prints contents of linked list starting from the given node
	 */
	public static void printList(Node node) {

		Node n = node;
		while (n != null) {
			System.out.print(n.data + " => ");
			n = n.next;
		}
		System.out.println("NULL");
	}

	/**
	 * This method finds the middle element of the linked list
	 */
	private static int findMiddle(Node node) {

		// Creating slow and fast pointers
		Node slow = node;
		Node fast = node;

		while (fast != null && fast.next != null) {
			// Move slow pointer one element forward
			slow = slow.next;
			// Move fast pointer two elements forward
			fast = fast.next;
		}

		return slow.data;
	}

	public static void main(String[] args) {
		// Add some elements in the node
		for (int i = 6; i > 0; --i) {
			push(i);
		}

		System.out.println("Original linked list:");
		printList(head);

		// Find the middle element of the linked list
		System.out.println("Middle element: " + findMiddle(head));
	}
}
