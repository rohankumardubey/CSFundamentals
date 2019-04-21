package org.redquark.csfundamentals.dswithjava.tests.stacks;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.redquark.csfundamentals.dswithjava.stacks.Stack;

/**
 * @Author Anirudh Sharma
 * <p>
 * This class tests the List based implementation of Stack
 */
public class StackTest {

	// Instance of Stack
	private Stack<Integer> stack;

	@Before
	public void setUp() {
		// Initialize the instance
		stack = new Stack<>();

		// Add some data
		for (int i = 1; i <= 10; i++) {
			stack.push(i);
		}
	}

	@Test
	public void testIsEmpty() {
		Assert.assertNull(stack.clear());
	}

	@Test
	public void testPush() {
		Assert.assertEquals(stack.push(11).toString(), "[11 10 9 8 7 6 5 4 3 2 1 ]");
	}

	@Test
	public void testPop() {
		for (int i = 0; i < 3; i++) {
			stack.pop();
		}
		Assert.assertEquals(stack.pop(), Integer.valueOf(7));
	}

	@Test
	public void testPeek() {
		for (int i = 0; i < 4; i++) {
			Assert.assertEquals(stack.peek(), Integer.valueOf(10));
		}
	}
}
