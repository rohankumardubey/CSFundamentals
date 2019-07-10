package org.redquark.csfundamentals.dswithjava.trees;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Stack;

/**
 * @author Anirudh Sharma
 *
 */
public class BinarySearchTree<T extends Comparable<T>> implements Iterable<T> {

	public static void main(String[] args) {

		Integer[] items = { 1, 5, 2, 7, 4 };
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();

		for (Integer i : items) {
			bst.insert(i);
		}

		// PreOrder Traversal
		System.out.println("Pre Order Traversal:");
		bst.preOrderTravesal();

		// InOrder Traversal
		System.out.println("\nIn Order Traversal");
		bst.inOrderTraversal();

		// Post Order traversal
		System.out.println("\nPost Order Traversal");
		bst.postOrderTraversal();

		/*
		 * Testing comparator - Build a mirror BST with a rule Left > Parent > Right
		 */
		bst = (BinarySearchTree<Integer>) new BinarySearchTree<>(new CustomComparator());
		for (Integer i : items) {
			bst.insert(i);
		}

		// Again traversal
		System.out.println("\nSecond Pre Order Traversal");
		bst.preOrderTravesal();
		System.out.println("\nSecond In Order Traversal");
		bst.inOrderTraversal();
		System.out.println("\nSecond Post Order Traversal");
		bst.postOrderTraversal();

		System.out.println(bst);

		// Diameter
		System.out.println("Diameter = " + bst.diameter());
		// Width
		System.out.println("Width = " + bst.width());
		// Height
		System.out.println("Height = " + bst.height());
	}

	// Root node
	private Node<T> root;

	// Comparator
	private Comparator<T> comparator;

	public BinarySearchTree() {
		root = null;
		this.comparator = null;
	}

	public BinarySearchTree(Comparator<T> comparator) {
		root = null;
		this.comparator = comparator;
	}

	private int compare(T x, T y) {
		if (comparator == null) {
			return x.compareTo(y);
		} else {
			return comparator.compare(x, y);
		}
	}

	/*****************************************************
	 *
	 * INSERT
	 *
	 ******************************************************/
	public void insert(T data) {
		root = insert(root, data);
	}

	private Node<T> insert(Node<T> node, T toInsert) {

		// If the root is null then we create a new node and assign it to the root node
		if (node == null) {
			return new Node<T>(toInsert);
		}

		// If the value already present in the node, then we will not add that data in
		// the tree
		if (compare(toInsert, node.data) == 0) {
			return node;
		}

		// If the node is less than the current node, the we will create the left
		// subtree,
		// Else we will create the right subtree.
		if (compare(toInsert, node.data) < 0) {
			node.left = insert(node.left, toInsert);
		} else {
			node.right = insert(node.right, toInsert);
		}

		return node;
	}

	/*****************************************************
	 *
	 * SEARCH
	 *
	 ******************************************************/
	public boolean search(T data) {
		return search(root, data);
	}

	private boolean search(Node<T> node, T toSearch) {

		// If the root is null
		if (node == null) {
			return false;
		} else {

			// If the data in current node is equal to the item to search
			if (compare(toSearch, node.data) == 0) {
				return true;
			} else {
				// If the data to search is less than the data in current node, we will traverse
				// the left subtree, else we will search the right subtree.
				if (compare(toSearch, node.data) < 0) {
					return search(node.left, toSearch);
				} else {
					return search(node.right, toSearch);
				}
			}
		}
	}

	/*****************************************************
	 *
	 * DELETE
	 *
	 ******************************************************/
	public void delete(T data) {
		root = delete(root, data);
	}

	private Node<T> delete(Node<T> node, T toDelete) {

		if (node == null) {
			throw new RuntimeException("Cannot delete!");
		} else if (compare(node.data, toDelete) < 0) {
			node.left = delete(node.left, toDelete);
		} else if (compare(node.data, toDelete) > 0) {
			node.right = delete(node.right, toDelete);
		} else {
			if (node.left == null) {
				return node.right;
			} else if (node.right == null) {
				return node.left;
			} else {
				// Get data from the rightmost node in the left subtree
				node.data = retrieveData(node.left);
				// Delete the rightmost node in the left subtree
				node.left = delete(node.left, node.data);
			}
		}
		return node;
	}

	private T retrieveData(Node<T> node) {
		while (node.right != null) {
			node = node.right;
		}
		return node.data;
	}

	/*****************************************************
	 *
	 * toString
	 *
	 ******************************************************/
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (T data : this) {
			sb.append(data.toString());
		}
		return sb.toString();
	}

	/*************************************************
	 *
	 * TRAVERSAL
	 *
	 **************************************************/
	public void preOrderTravesal() {
		preOrderHelper(root);
	}

	private void preOrderHelper(Node<T> node) {
		if (node != null) {
			System.out.print(node.data + " ");
			preOrderHelper(node.left);
			preOrderHelper(node.right);
		}
	}

	public void inOrderTraversal() {
		inOrderHelper(root);
	}

	private void inOrderHelper(Node<T> node) {
		if (node != null) {
			inOrderHelper(node.left);
			System.out.print(node.data + " ");
			inOrderHelper(node.right);
		}
	}

	public void postOrderTraversal() {
		postOrderHelper(root);
	}

	private void postOrderHelper(Node<T> node) {
		if (node != null) {
			postOrderHelper(node.left);
			postOrderHelper(node.right);
			System.out.print(node.data + " ");
		}
	}

	/*************************************************
	 *
	 * CLONE
	 *
	 **************************************************/
	public BinarySearchTree<T> clone() {

		BinarySearchTree<T> twin = null;

		if (comparator == null) {
			twin = new BinarySearchTree<T>();
		} else {
			twin = new BinarySearchTree<>(comparator);
		}

		twin.root = cloneHelper(root);

		return twin;
	}

	private Node<T> cloneHelper(Node<T> node) {
		if (node == null) {
			return null;
		} else {
			return new Node<T>(node.data, cloneHelper(node.left), cloneHelper(node.right));
		}
	}

	/*************************************************
	 *
	 * Height
	 *
	 **************************************************/
	public int height() {
		return height(root);
	}

	private int height(Node<T> node) {
		if (node == null) {
			return -1;
		} else {
			return 1 + Math.max(height(node.left), height(node.right));
		}
	}

	/*************************************************
	 *
	 * Count Leaves
	 *
	 **************************************************/
	public int countLeaves() {
		return countLeaves(root);
	}

	private int countLeaves(Node<T> node) {
		if (node == null) {
			return 0;
		} else if (node.left == null && node.right == null) {
			return 1;
		} else {
			return countLeaves(node.left) + countLeaves(node.right);
		}
	}

	/*************************************************
	 *
	 * Width - The width of a binary tree is the maximum number of elements on one
	 * level of the tree
	 *
	 **************************************************/
	public int width() {
		int max = 0;
		for (int i = 0; i < height(); i++) {
			int temp = width(root, i);
			if (temp > max) {
				max = temp;
			}
		}
		return max;
	}

	private int width(Node<T> node, int depth) {
		if (node == null) {
			return 0;
		} else if (depth == 0) {
			return 1;
		} else {
			return width(node.left, depth - 1) + width(node.right, depth - 1);
		}
	}

	/*************************************************
	 *
	 * Diameter - The diameter of a tree is the number of nodes on the longest path
	 * between two leaves in the tree.
	 *
	 **************************************************/
	public int diameter() {
		return diameter(root);
	}

	private int diameter(Node<T> node) {
		if (node == null) {
			return 0;
		}

		// The path goes through the root
		int a = height(node.left) + height(node.right) + 3;

		// The path does not pass through the root
		int b = Math.max(diameter(node.left), diameter(node.right));

		return Math.max(a, b);
	}

	/*****************************************************
	 *
	 * The Node class
	 *
	 ******************************************************/
	@SuppressWarnings("hiding")
	private class Node<T> {

		private T data;
		private Node<T> left;
		private Node<T> right;

		/**
		 * @param data
		 * @param left
		 * @param right
		 */
		public Node(T data, Node<T> left, Node<T> right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}

		/**
		 * @param data
		 */
		public Node(T data) {
			this(data, null, null);
		}

		@Override
		public String toString() {
			return data.toString();
		}
	}

	/*****************************************************
	 *
	 * TREE ITERATOR
	 *
	 ******************************************************/
	@Override
	public Iterator<T> iterator() {
		return new BSTIterator();
	}

	private class BSTIterator implements Iterator<T> {

		Stack<Node<T>> stack = new Stack<>();

		public BSTIterator() {
			if (root != null) {
				stack.push(root);
			}
		}

		@Override
		public boolean hasNext() {
			return !stack.isEmpty();
		}

		@Override
		public T next() {

			Node<T> current = stack.peek();

			if (current.left != null) {
				stack.push(current.left);
			} else {
				Node<T> temp = stack.pop();
				while (temp.right == null) {
					if (stack.isEmpty()) {
						return current.data;
					}
					temp = stack.pop();
				}
				stack.push(temp.right);
			}
			return current.data;
		}

	}
}

class CustomComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		return o2 - o1;
	}

}
