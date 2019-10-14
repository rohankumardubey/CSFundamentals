package org.redquark.problems.miscellaneous;

/**
 * There are two singly linked lists in a system. By some programming error, the
 * end node of one of the linked list got linked to the second list, forming an
 * inverted Y shaped list. Write a program to get the point where two linked
 * list merge.
 * 
 * @author Anirudh Sharma
 *
 */
public class IntersectionPointOfLinkedLists {

	// Heads of the two linked lists
	private Node head1;
	private Node head2;

	private static class Node {

		// Data to be stored in node of the linked list
		private int data;
		// Next pointer of the node
		private Node next;

		// Constructor to create node of a linked list
		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	/**
	 * This method returns the data stored in intersecting node
	 */
	private int getIntersectionNode(Node n1, Node n2) {
		// Base condition of lists are null or non existing
		if (n1 == null || n2 == null) {
			return -1;
		}

		// Get node count in first linked list
		int count1 = getNodeCount(n1);
		// Get node count in second linked list
		int count2 = getNodeCount(n2);

		// Difference between the nodes
		int d = Math.abs(count1 - count2);

		// Temporary node reference pointer
		Node big;
		// head of the smaller list
		Node smallHead;
		// If list 1 is bigger
		if (count1 > count2) {
			big = n1;
			smallHead = n2;
		} else {
			// If list 2 is bigger
			big = n2;
			smallHead = n1;
		}

		// Loop the bigger list until the difference
		for (int i = 0; i < d; i++) {
			big = big.next;
		}
		// At this point we have temp with the reference to the node from where we are
		// going to compare both lists
		while (big.next != null) {
			if (big.data == smallHead.data) {
				return big.data;
			} else {
				big = big.next;
				smallHead = smallHead.next;
			}
		}

		return -1;
	}

	/**
	 * This method returns the count of nodes in a linked list
	 */
	private static int getNodeCount(Node n) {
		// Initializing the counter
		int count = 0;

		while (n != null) {
			count++;
			n = n.next;
		}

		return count;
	}

	public static void main(String[] args) {
		IntersectionPointOfLinkedLists list = new IntersectionPointOfLinkedLists();

		// creating first linked list
		list.head1 = new Node(3);
		list.head1.next = new Node(6);
		list.head1.next.next = new Node(9);
		list.head1.next.next.next = new Node(15);
		list.head1.next.next.next.next = new Node(30);

		// creating second linked list
		list.head2 = new Node(10);
		list.head2.next = new Node(15);
		list.head2.next.next = new Node(30);

		// Find the intersection node
		System.out.println(list.getIntersectionNode(list.head1, list.head2));
	}

}
