package org.redquark.problems.miscellaneous;

/**
 * Given a pointer to a node to be deleted, delete the node. Note that we don’t
 * have pointer to head node.
 * 
 * @author Anirudh Sharma
 *
 */
public class DeleteGivenNodeWithoutHeaderPointer<T> {

	private Node<T> head;

	public static void main(String[] args) {

		// Creating instance of this class
		DeleteGivenNodeWithoutHeaderPointer<Character> obj = new DeleteGivenNodeWithoutHeaderPointer<>();

		// Adding some data
		obj.add('A');
		obj.add('B');
		obj.add('C');
		obj.add('D');
		obj.add('E');
		obj.add('F');

		// Print the list before deletion
		System.out.println("Before deletion");
		obj.print();

		// Delete the node
		obj.delete(obj.head.next.next);

		// Print the list after deletion
		System.out.println("\nAfter deletion");
		obj.print();
	}

	/**
	 * This method just adds new node to the existing linked list in a reverse order
	 * of addition
	 */
	private void add(T data) {
		// Create a new node and add data
		Node<T> newNode = new Node<T>(data);
		// Make the next of new node as head
		newNode.next = head;
		// Make the new node as head
		head = newNode;
	}

	/**
	 * This method just prints the nodes in a linked list
	 */
	private void print() {
		// Getting reference to the head node
		Node<T> node = head;
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}

	/**
	 * This method deletes the given node by copying the data of next node into the
	 * given node
	 */
	private void delete(Node<T> node) {
		// Preserving the next of the node to be deleted in a variable
		Node<T> temp = node.next;
		// Copying data of next to the node itself
		node.data = temp.data;
		// Pointing the next of the node to the next of the next of the node to be
		// deleted
		node.next = temp.next;
	}

	/**
	 * Inner class that represents node
	 * 
	 * @author Anirudh Sharma
	 *
	 * @param <T>
	 */
	private static class Node<T> {

		// Data to be stored in the node of the linked list
		private T data;
		// Next pointer of the node
		private Node<T> next;

		/**
		 * This constructor will be used to create a new node
		 */
		public Node(T data) {
			this.data = data;
			this.next = null;
		}
	}
}
