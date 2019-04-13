package org.redquark.csfundamentals.dswithjava.tests.linkedlists.problems;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.redquark.csfundamentals.dswithjava.linkedlists.problems.IntersectionPoint;

/**
 * This class tests IntersectionPoint class
 *
 * @Author Anirudh Sharma
 */
public class IntersectionPointTest {

	// Instance
	private IntersectionPoint<Integer> firstList;
	private IntersectionPoint<Integer> secondList;

	@Before
	public void setUp() {
		// Instantiation
		firstList = new IntersectionPoint<>();
		secondList = new IntersectionPoint<>();

		// Add some data
		firstList.add(3);
		firstList.add(6);
		firstList.add(15);
		firstList.add(15);
		firstList.add(30);

		secondList.add(10);
		secondList.add(15);
		secondList.add(30);
	}

	/**
	 * This method tests the data that will find the intersection point of two linked lists
	 */
	@Test
	public void testFindIntersectionPoint() {
		Assert.assertEquals(firstList.findIntersectionPoint(firstList, secondList), Integer.valueOf(15));
	}
}
