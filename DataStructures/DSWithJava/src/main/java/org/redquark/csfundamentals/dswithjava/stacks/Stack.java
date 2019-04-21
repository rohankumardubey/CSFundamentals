package org.redquark.csfundamentals.dswithjava.stacks;

interface StackInterface<T> {

	// Tests if the stack is empty
	boolean isEmpty();

	// Removes and returns an item at the top of the Stack
	T pop() throws RuntimeException;

	// Returns the top element without its removal
	T peek() throws RuntimeException;

	// Inserts an item on top of the Stack
	Stack<T> push(T item) throws RuntimeException;

	// Removes all items from the Stack
	Stack.Node<T> clear();
}

/**
 * This class is the List based implementation of a Stack
 *
 * @param <T>
 * @Author Anirudh Sharma
 */
public class Stack<T> implements StackInterface<T> {

	// Top of the Stack
	private Node<T> top;

	/**
	 * Constructor to create a Stack
	 */
	public Stack() {
		top = null;
	}

	/**
	 * This method check if the stack is empty
	 *
	 * @return if the Stack is empty
	 */
	@Override
	public boolean isEmpty() {
		return top == null;
	}

	/**
	 * This method returns the top after deleting it.
	 *
	 * @return T
	 */
	@Override
	public T pop() throws RuntimeException {
		if (isEmpty()) {
			throw new RuntimeException("Stack is empty");
		}
		T data = top.data;
		top = top.next;
		return data;
	}

	/**
	 * This method returns the top without deleting it
	 *
	 * @return T
	 */
	@Override
	public T peek() throws RuntimeException {
		if (isEmpty()) {
			throw new RuntimeException("Stack is empty");
		}
		return top.data;
	}

	/**
	 * Adds a new element to the top of the Stack
	 *
	 * @param item - Data to be stored in the Stack
	 */
	@Override
	public Stack<T> push(T item) throws RuntimeException {
		top = new Node<>(item, top);
		return this;
	}

	/**
	 * This method clears the Stack
	 */
	@Override
	public Node<T> clear() {
		// Stack is cleared by making top equals to null
		top = null;
		return top;
	}

	/**
	 * Returns a string representation of the Stack.
	 */
	public String toString() {

		if (isEmpty()) {
			return "[]";
		}

		StringBuilder out = new StringBuilder("[");
		Node<T> tmp = top;
		while (tmp != null) {
			out.append(tmp.data).append(" ");
			tmp = tmp.next;
		}

		out.append("]");
		return out.toString();
	}

	static class Node<T> {
		// Data to be stored in the node
		private T data;
		// Pointer to the next node
		private Node<T> next;

		/**
		 * Constructor
		 *
		 * @param data - data to be stored in the node
		 */
		Node(T data) {
			this(data, null);
		}

		/**
		 * Constructor
		 *
		 * @param data - data to be stored in the node
		 * @param next - next pointer of the node
		 */
		Node(T data, Node<T> next) {
			this.data = data;
			this.next = next;
		}
	}
}
