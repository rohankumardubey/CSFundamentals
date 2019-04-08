package org.redquark.csfundamentals.dswithjava.tests.linkedlists.problems;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.redquark.csfundamentals.dswithjava.linkedlists.problems.FindMiddleElement;

/**
 * @Author Anirudh Sharma
 */
public class FindMiddleElementTest {

	private FindMiddleElement<Integer> findMiddleElement;

	@Before
	public void setUp() {

		// Initializing the list
		findMiddleElement = new FindMiddleElement<>();

		// Add some data to the list
		findMiddleElement.add(1);
		findMiddleElement.add(2);
		findMiddleElement.add(3);
		findMiddleElement.add(3);
		findMiddleElement.add(5);
		findMiddleElement.add(6);
		findMiddleElement.add(7);
		findMiddleElement.add(8);
		findMiddleElement.add(9);
		findMiddleElement.add(10);
		findMiddleElement.add(11);
		findMiddleElement.add(12);
	}

	/**
	 * This method tests the findMiddle method
	 */
	@Test
	public void testFindMiddle() {
		Assert.assertEquals(findMiddleElement.findMiddle(), Integer.valueOf(7));
	}
}
