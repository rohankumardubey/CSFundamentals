package org.redquark.csfundamentals.dswithjava.tests.linkedlists.problems;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.redquark.csfundamentals.dswithjava.linkedlists.problems.UnionAndIntersection;

/**
 * This class tests the {@link UnionAndIntersection} class
 *
 * @Author Anirudh Sharma
 */
public class UnionAndIntersectionTest {

	// Instances of the UnionAndIntersection class
	private UnionAndIntersection<Integer> firstList;
	private UnionAndIntersection<Integer> secondList;

	@Before
	public void setUp() {
		// Instantiating the instance
		firstList = new UnionAndIntersection<>();
		secondList = new UnionAndIntersection<>();

		// Add data to first list
		firstList.add(3);
		firstList.add(5);
		firstList.add(4);
		firstList.add(9);
		firstList.add(1);

		// Add data to second list
		secondList.add(4);
		secondList.add(6);
		secondList.add(3);
		secondList.add(7);
	}

	/**
	 * This method tests the union method
	 */
	@Test
	public void testUnion() {
		Assert.assertEquals(firstList.union(firstList, secondList).toString(), "[3, 5, 4, 9, 1, 6, 7]");
	}

	/**
	 * This method tests the intersection method
	 */
	@Test
	public void testIntersection() {
		Assert.assertEquals(secondList.intersection(firstList, secondList).toString(), "[4, 3]");
	}
}
