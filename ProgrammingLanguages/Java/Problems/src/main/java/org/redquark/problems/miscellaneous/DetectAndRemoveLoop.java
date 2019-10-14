package org.redquark.problems.miscellaneous;

/**
 * Write a function detectAndRemoveLoop() that checks whether a given Linked
 * List contains loop and if loop is present then removes the loop and returns
 * true. If the list doesn’t contain loop then it returns false. Below diagram
 * shows a linked list with a loop. detectAndRemoveLoop() must change the below
 * list to 1->2->3->4->5->NULL.
 * 
 * @author Anirudh Sharma
 *
 */
public class DetectAndRemoveLoop {

	// Head of the Linked List
	private static Node head;

	/**
	 * Node class that represents each node of the Linked List
	 */
	private static class Node {

		// Data to be stored in the node
		private int data;
		// Next pointer of the node
		private Node next;

		/**
		 * This constructor creates one node with the given data
		 */
		public Node(int data) {
			this.data = data;
		}
	}

	/**
	 * This method detects and removes loop in a LinkedList
	 */
	private static void detectAndRemoveLoop(Node node) {

		// Slow pointer
		Node slow = node.next;
		// Fast pointer
		Node fast = node.next.next;

		// Iterate until we find the loop
		while (fast != null && fast.next != null) {
			// Check if slow and fast are pointing to the same node
			if (slow == fast) {
				break;
			}

			// Move slow pointer by one node
			slow = slow.next;
			// Move fast pointer by two nodes
			fast = fast.next.next;
		}

		// Checks if slow = fast i.e. loop in the linked list is present
		if (slow == fast) {
			// Pointing slow pointer to the head
			slow = node;
			// Loop until slow and fast do not meet
			while (slow.next != fast.next) {
				// Move both pointers with the same pace
				slow = slow.next;
				fast = fast.next;
			}

			// Pointing last node in the loop to null to remove the loop
			fast.next = null;
		}
	}

	/**
	 * Utility method to print the elements of the list
	 */
	private static void printList(Node node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}

	public static void main(String[] args) {

		head = new Node(50);
		head.next = new Node(20);
		head.next.next = new Node(15);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(10);

		// Creating a loop for testing
		head.next.next.next.next.next = head.next.next;
		// Detect and remove loop from the linked list
		detectAndRemoveLoop(head);
		System.out.print("Linked List after removing loop : ");
		printList(head);

	}
}
