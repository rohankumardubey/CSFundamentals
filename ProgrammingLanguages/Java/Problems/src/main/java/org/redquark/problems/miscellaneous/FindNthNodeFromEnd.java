package org.redquark.problems.miscellaneous;

/**
 * Given a Linked List and a number n, write a function that returns the value
 * at the nth node from the end of the Linked List.
 * 
 * @author Anirudh Sharma
 *
 */
public class FindNthNodeFromEnd {

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

	private static int findNthNode(Node node, int k) {

		Node reference = node;
		Node main = node;

		for (int i = 0; i < k; i++) {
			reference = reference.next;
		}

		while (reference != null) {
			reference = reference.next;
			main = main.next;
		}

		return main.data;

	}

	public static void main(String[] args) {
		// Add some elements in the node
		for (int i = 6; i > 0; --i) {
			push(i);
		}

		System.out.println("Original linked list:");
		printList(head);

		// Find the middle element of the linked list
		System.out.println("3rd element from the last: " + findNthNode(head, 3));
	}
}
