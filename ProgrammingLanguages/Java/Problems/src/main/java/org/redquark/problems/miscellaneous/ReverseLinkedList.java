package org.redquark.problems.miscellaneous;

/**
 * @author Anirudh Sharma
 *
 */
public class ReverseLinkedList {

	private static Node head;

	private static class Node {

		private int data;
		private Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	private static Node reverse(Node node) {

		// Previous pointer
		Node previous = null;
		// Current pointer
		Node current = node;
		// Next pointer
		Node next = node;

		// Loop through the entire linked list
		while (current != null) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		node = previous;
		return node;
	}

	private static void print(Node node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}

	public static void main(String[] args) {

		head = new Node(85);
		head.next = new Node(15);
		head.next.next = new Node(4);
		head.next.next.next = new Node(20);

		System.out.println("Original list:");
		print(head);
		// Reversing the list
		head = reverse(head);
		System.out.println("\nReversed list: ");
		print(head);
	}

}
