package org.redquark.problems.miscellaneous;

/**
 * A tree where no leaf is much farther away from the root than any other leaf.
 * Different balancing schemes allow different definitions of “much farther” and
 * different amounts of work to keep them balanced.
 * 
 * Consider a height-balancing scheme where following conditions should be
 * checked to determine if a binary tree is balanced. An empty tree is
 * height-balanced. A non-empty binary tree T is balanced if: 
 * 1) Left subtree of T is balanced 
 * 2) Right subtree of T is balanced 
 * 3) The difference between heights of left subtree and right subtree is not more than 1.
 * 
 * @author Anirudh Sharma
 *
 */
public class HeightBalancedTree<T> {

	private Node<T> root;

	private static class Node<T> {

		// Data to be stored in the node
		@SuppressWarnings("unused")
		private T data;
		// Left and right pointers
		private Node<T> left;
		private Node<T> right;

		// Constructor to create nodes
		public Node(T data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	/**
	 * Wrapper class to modify height across recursive calls
	 * 
	 * @author Anirudh Sharma
	 */
	private static class Height {
		int height = 0;
	}

	private boolean isBalanced(Node<T> node, Height height) {
		// Base condition - if tree is empty, return true
		if (node == null) {
			height.height = 0;
			return true;
		}

		// Get height of left and right subtrees
		Height lh = new Height();
		Height rh = new Height();

		// Check if subtrees are balanced recursively
		boolean l = isBalanced(node.left, lh);
		boolean r = isBalanced(node.right, rh);

		int leftH = lh.height;
		int rightH = rh.height;

		// Height of current node is maximum of heights of its left and right subtrees
		// plus 1
		height.height = (leftH > rightH ? leftH : rightH) + 1;

		// If difference between heights is greater than 1 then the trees are not
		// balanced
		if ((Math.abs(leftH - rightH)) > 1) {
			return false;
		} else {
			// If difference is equal to or less than one then we will check if the subrees
			// are balanced or not
			return l && r;
		}
	}

	public static void main(String[] args) {

		// Instance of Height wrapper class
		Height h = new Height();

		// Instance of this class to call methods
		HeightBalancedTree<Integer> tree = new HeightBalancedTree<>();
		tree.root = new Node<Integer>(1);
		tree.root.left = new Node<Integer>(2);
		tree.root.right = new Node<Integer>(3);
		tree.root.left.left = new Node<Integer>(4);
		tree.root.left.right = new Node<Integer>(5);
		tree.root.right.right = new Node<Integer>(6);
		tree.root.left.left.left = new Node<Integer>(7);

		System.out.println(tree.isBalanced(tree.root, h) ? "Balanced" : "Not balanced");

	}

}
