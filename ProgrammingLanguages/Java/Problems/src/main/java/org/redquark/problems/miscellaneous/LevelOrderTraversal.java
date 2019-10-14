package org.redquark.problems.miscellaneous;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Anirudh Sharma
 *
 */
public class LevelOrderTraversal {

	/**
	 * Node class to represent each node of the binary tree
	 */
	private static class Node {

		// Data to be stored in the node
		int data;
		// Left child of the tree
		Node left;
		// Right child of the tree
		Node right;

		/**
		 * Constructor to create a new node in the tree
		 */
		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	/**
	 * This method prints the level order traversal of the Binary Tree
	 */
	private static void levelOrder(Node node) {

		// Base condition - root is null i.e. no Tree exists
		if (node == null) {
			return;
		}

		// Queue to store data of the tree nodes
		Queue<Node> q = new LinkedList<>();

		// Enqueue root to the queue
		q.add(node);

		// Loop until we reach the boundary condition
		while (true) {

			// Get the size of the Queue
			int size = q.size();

			// Check if size is 0
			if (size == 0) {
				// Break the loop
				break;
			}

			// Loop until we have Queue size more than 0
			while (size > 0) {
				// Get the front of the queue without removing it
				Node temp = q.peek();
				System.out.print(temp.data + " ");
				// Remove the front
				q.remove();

				// Check queue for the left and right subtrees
				if (temp.left != null) {
					q.add(temp.left);
				}
				if (temp.right != null) {
					q.add(temp.right);
				}
				// Decrement size by 1
				size--;
			}
		}
	}

	public static void main(String[] args) {

		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.right = new Node(6);

		levelOrder(root);
	}
}
