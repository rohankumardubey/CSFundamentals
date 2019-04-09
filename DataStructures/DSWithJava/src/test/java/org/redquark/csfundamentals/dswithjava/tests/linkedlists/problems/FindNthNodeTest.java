package org.redquark.csfundamentals.dswithjava.tests.linkedlists.problems;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.redquark.csfundamentals.dswithjava.linkedlists.problems.FindNthNode;

/**
 * This class tests the FindNthNode class
 *
 * @Author Anirudh Sharma
 */
public class FindNthNodeTest<T> {

	// Instance of FindNthNode class
	private FindNthNode<Integer> findNthNode;

	@Before
	public void setUp() {
		// Initialize the instance
		findNthNode = new FindNthNode<>();

		// Set up the data
		findNthNode.add(1);
		findNthNode.add(2);
		findNthNode.add(3);
		findNthNode.add(4);
		findNthNode.add(5);
		findNthNode.add(6);
		findNthNode.add(7);
		findNthNode.add(8);
	}

	/**
	 * This method tests the method which determines the Nth node from the start of the linked list
	 */
	@Test
	public void testFromStart() {
		Assert.assertEquals(findNthNode.fromStart(3), Integer.valueOf(3));
	}

	/**
	 * This method tests the method which determines the Nth node from the end of the linked list
	 */
	@Test
	public void testFromEnd() {
		Assert.assertEquals(findNthNode.fromEnd(4), Integer.valueOf(5));
	}
}
