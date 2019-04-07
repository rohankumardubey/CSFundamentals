package org.redquark.csfundamentals.dswithjava.linkedlists;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class represents the implementation of a Singly Linked List from scratch.
 * It contains various methods related to normal linked list operations.
 *
 * @Author Anirudh Sharma
 */
public class SinglyLinkedList<T> {

	// Head of the linked list
	private Node<T> head;

	/**
	 * Default constructor - This will create an empty linked list
	 */
	public SinglyLinkedList() {
		// Creating an empty linked list by setting head to null
		head = null;
	}

	/**
	 * This method will check if the list is empty
	 *
	 * @return boolean
	 */
	public boolean isEmpty() {
		// Boolean condition will evaluate to true if the linked list is empty
		return head == null;
	}

	/**
	 * This method initializes the linked list by creating head node
	 *
	 * @param data - Data of the head node
	 */
	public void addFirst(T data) {
		// Creating a new linked list with the head node having the passed data
		head = new Node<>(data, head);
	}

	/**
	 * This method will add a new node in the linked list at the end
	 *
	 * @param data - Data of the node
	 */
	public void addLast(T data) {
		// If head is null - which means list is empty.
		// We have to create a new linked with the head having the data passed
		if (head == null) {
			// Calling the method to create the head
			addFirst(data);
		} else {
			// Getting reference of the head
			Node<T> node = head;
			// Iterate until we reach to the end of the linked list
			while (node.next != null) {
				// Moving the reference of the node
				node = node.next;
			}
			// Create a new node and add it to the last of the linked list.
			// The next pointer of the last node would be null.
			node.next = new Node<>(data, null);
		}
	}

	/**
	 * This method returns the head of the linked list
	 *
	 * @return T
	 */
	public T getFirst() {
		// If the head is null, which means there is no linked list
		if (head == null) {
			throw new NoSuchElementException();
		}
		// If the head is not null, return the data stored in the head node
		return head.data;
	}

	/**
	 * This method will return the data stored in the last node in the linked
	 * list
	 *
	 * @return T
	 */
	public T getLast() {
		// If the head is null, which means there is no linked list
		if (head == null) {
			throw new NoSuchElementException();
		}
		// Get the reference of the head node
		Node<T> node = head;
		// Iterate until we reach the end of the linked list
		while (node.next != null) {
			// Moving the reference of next pointer
			node = node.next;
		}
		// Return the data of the last node
		return node.data;
	}

	/**
	 * This method removes the head of the linked list
	 *
	 * @return T
	 */
	public T removeFirst() {
		// Getting the head of the linked list
		T data = getFirst();
		// Referencing the head to next node of the head
		head = head.next;
		// Return the data stored in the last node of the linked list
		return data;
	}

	/**
	 * This method removes the last element from the linked list
	 *
	 * @return T
	 */
	public T removeLast() {
		// If head is null then there is no linked list
		if (head == null) {
			throw new NoSuchElementException();
		}
		// Getting the reference of the head node
		Node<T> node = head;
		// Iterate until the second last element of the linked list
		while (node.next.next != null) {
			// Moving the pointer to the next node
			node = node.next;
		}
		// Getting the data stored in the last node
		T data = node.next.data;
		// Make the second last pointer point to null
		node.next = null;
		// Return the data stored in the node
		return data;
	}

	/**
	 * Clears the list - Removes all the nodes in the linked list
	 */
	public Node<T> clear() {
		// Set the head node to null which finishes the existence of the list
		head = null;
		return null;
	}

	/**
	 * This method checks if the specified element is present in the linked list
	 *
	 * @param item - Item to be searched
	 * @return boolean
	 */
	public boolean contains(T item) {
		// Getting the reference of the head node
		Node<T> node = head;
		// Iterate the linked list until the element is found or reached to
		// the end of the list
		while (node.next != null) {
			// Compare if the data of current node is equal to the element
			// specified
			if (node.data == item) {
				// If found, return true...
				return true;
			}
			// Moving the pointer to the next node
			node = node.next;
		}
		//... else return false
		return false;
	}

	/**
	 * This method will return the data stored in the node at the specified
	 * position
	 *
	 * @param position - position at which we need to find the node
	 * @return T
	 */
	public T get(int position) {
		// If the head is null, which means there is no linked list
		if (head == null) {
			// Throw exception suggesting that the index is out of bounds
			throw new IndexOutOfBoundsException();
		}
		// Getting the reference of the head node
		Node<T> node = head;
		// Iterate the loop until we reach to the specified position
		for (int i = 0; i < position; i++) {
			node = node.next;
		}
		// If the node at specified position is null which means there are
		// not many elements as the specified position
		if (node == null) {
			// Throw exception suggesting that the index is out of bounds
			throw new IndexOutOfBoundsException();
		}
		// Return the data stored at the node
		return node.data;
	}

	/**
	 * This method inserts a node after the specified node
	 *
	 * @param key  - Node data after which we wish to insert a new node
	 * @param item - Data of the new node
	 */
	public void insertAfter(T key, T item) {
		// Getting the reference of the head node
		Node<T> node = head;
		// Iterate until we reach to the end of the linked list or to the
		// specified node
		while (node != null && !node.data.equals(key)) {
			// Moving the pointer to the next node
			node = node.next;
		}
		// If the specified node (after which we wish to add) is not null
		// then we will create a new node after it
		if (node != null) {
			// Pointing the next pointer of the specified node to the newly
			// created node and its pointer to the node after the specified node
			node.next = new Node<>(item, node.next);
		}
	}

	/**
	 * This method inserts a new node before the specified node
	 *
	 * @param key  - the node before which we need to insert
	 * @param item - Data of the node to be inserted
	 */
	public void insertBefore(T key, T item) {
		// If there is no list, then return
		if (head == null) {
			return;
		}
		// If there is only one node in the linked list - which will be the
		// head of the linked list
		if (head.data.equals(key)) {
			// Call the method to add a new head
			addFirst(item);
			return;
		}
		// Previous node
		Node<T> previous = null;
		// Current node
		Node<T> current = head;

		// Iterate until we reach the end of the node or to the specified node
		while (current != null && !current.data.equals(key)) {
			previous = current;
			current = current.next;
		}
		// Insert the new node between prevoius and current
		if (current != null && previous != null) {
			// Pointing prevoius to new node while the next of new node to
			// the current node
			previous.next = new Node<>(item, current);
		}
	}

	/**
	 * This method will remove the first occurrence of the node which
	 * contains the specified key
	 *
	 * @param key - Item to remove
	 */
	public T remove(T key) {
		// If there is no linked list
		if (head == null) {
			throw new RuntimeException("Cannot delete");
		}
		// If the head is to be deleted
		if (head.data.equals(key)) {
			T data = head.data;
			head = head.next;
			return data;
		}
		// Previous node
		Node<T> previous = null;
		// Getting the reference of the head
		Node<T> current = head;
		// Iterate until we reach the end of the node or to the node which
		// has the specified data
		while (current != null && !current.data.equals(key)) {
			previous = current;
			current = current.next;
		}
		// Point the next of previous to next of current - this way we are
		// making the current node orphaned
		if (previous != null && current != null) {
			previous.next = current.next;
		} else {
			throw new RuntimeException("Cannot delete");
		}
		return current.data;
	}

	/**
	 * This method iterates the linked list
	 *
	 * @return Iterator
	 */
	private Iterator<T> iterator() {
		return new SinglyLinkedListIterator();
	}

	/**
	 * This method reverses the linked list
	 *
	 * @return SinglyLinkedList
	 */
	public SinglyLinkedList<T> reverse() {
		// Create a new SinglyLinkedList - which is empty in the starting
		SinglyLinkedList<T> list = new SinglyLinkedList<>();
		// Getting the reference of the head of the current linked list
		Node<T> node = head;
		// Iterate until we reach to the end of the current linked list
		while (node != null) {
			// Added each node of the current linked list as the first node
			// of the new linked list
			list.addFirst(node.data);
			// Moving the pointer to the next node
			node = node.next;
		}
		// Return the reversed list
		return list;
	}

	/**
	 * This method returns the size of the linked list
	 *
	 * @return int
	 */
	public int size() {
		// If there is no linked list
		if (head == null) {
			return 0;
		}
		// Counter to count the size of linked list
		int counter = 0;
		// Getting the reference of the head node
		Node<T> node = head;
		// Iterate until we reach to the end of the linked list
		while (node != null) {
			// Incrementing the counter
			counter++;
			// Moving the pointer to the next node
			node = node.next;
		}
		// Return the size of the linked list
		return counter;
	}

	/**
	 * Returns the deep copy of the linked list
	 *
	 * @return SinglyLinkedList
	 */
	public SinglyLinkedList<T> deepCopy() {
		// A new empty linked list
		SinglyLinkedList<T> twin = new SinglyLinkedList<>();
		// Getting the reference of the head of the current linked list
		Node<T> node = head;
		// Iterating until we reach the end of the list
		while (node != null) {
			// Added each element of the current linked list as the first
			// element of the new linked list
			twin.addFirst(node.data);
			// Moving the pointer to the next node
			node = node.next;
		}
		// Return the reverse of the new linked list
		return twin.reverse();
	}

	/**
	 * Overridden toString() method
	 *
	 * @return String
	 */
	public String toString() {
		Iterator<T> iterator = iterator();
		if (!iterator.hasNext()) {
			return "[]";
		}
		StringBuilder builder = new StringBuilder();
		builder.append('[');
		for (; ; ) {
			T item = iterator.next();
			builder.append(item);
			if (!iterator.hasNext()) {
				return builder.append(']').toString();
			}
			builder.append(", ");
		}
	}

	/**
	 * This class represents each node of the Linked List.
	 * Whenever a new node is created - it will be of type Node<T>
	 *
	 * @param <T>
	 */
	private static class Node<T> {

		// This will hold the data of the node
		private T data;

		// Next pointer - it will point to the next node in the linked list
		private Node<T> next;

		/**
		 * Constructor - This will be called when a node is created.
		 *
		 * @param data data to be stored in the node
		 * @param next next pointer of the next node
		 */
		Node(T data, Node<T> next) {
			this.data = data;
			this.next = next;
		}
	}

	/**
	 * Iterator implementation for this class
	 */
	private class SinglyLinkedListIterator implements Iterator<T> {

		// Next node
		private Node<T> nextNode;

		/**
		 * Constructor
		 */
		SinglyLinkedListIterator() {
			// Setting the nextNode to the reference of head node
			nextNode = head;
		}

		/**
		 * Returns {@code true} if the iteration has more elements.
		 * (In other words, returns {@code true} if {@link #next} would
		 * return an element rather than throwing an exception.)
		 *
		 * @return {@code true} if the iteration has more elements
		 */
		@Override
		public boolean hasNext() {
			// Returns true if the next node is not null
			return nextNode != null;
		}

		/**
		 * Returns the next element in the iteration.
		 *
		 * @return the next element in the iteration
		 * @throws NoSuchElementException if the iteration has no more elements
		 */
		@Override
		public T next() {
			// If the next node is null - throw exception
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			// Get the data of the next node
			T data = nextNode.data;
			// Move the pointer to the next node of the nextNode
			nextNode = nextNode.next;
			// Returns the data
			return data;
		}

		/**
		 * Remove the element
		 */
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
}
