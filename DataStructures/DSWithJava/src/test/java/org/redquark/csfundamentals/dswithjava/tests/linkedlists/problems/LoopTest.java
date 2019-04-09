package org.redquark.csfundamentals.dswithjava.tests.linkedlists.problems;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.redquark.csfundamentals.dswithjava.linkedlists.problems.Loop;

/**
 * This class tests Loop class
 *
 * @Author Anirudh Sharma
 */
public class LoopTest {

	private Loop<Integer> loop;

	@Before
	public void setUp() {
		// Creating an instance of the list
		loop = new Loop<>();

		// Add some data to the list
		loop.add(1);
		loop.add(2);
		loop.add(3);
		loop.add(3);
		loop.add(5);

		// Creating a loop in the linked list
		loop.head.next.next.next.next.next = loop.head.next;
	}

	/**
	 * This method tests if the linked list contains a loop
	 */
	@Test
	public void testDetectLoop() {
		Assert.assertTrue(loop.detectLoop());
	}

	/**
	 * This method tests the method to find the length of the linked list
	 */
	@Test
	public void testLoopLength() {
		loop.detectLoop();
		Assert.assertEquals(loop.loopLength(), 4);
	}

	/**
	 * This method tests if the loop is removed in the linked list
	 */
	@Test
	public void testRemoveLoop() {
		loop.detectLoop();
		loop.removeLoop();
		Assert.assertFalse(loop.detectLoop());
	}
}
