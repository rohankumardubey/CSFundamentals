package org.redquark.csfundamentals.dswithjava.tests.linkedlists.problems;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.redquark.csfundamentals.dswithjava.linkedlists.problems.EvenOdd;

/**
 * @Author Anirudh Sharma
 * <p>
 * This class tests EvenOdd class
 */
public class EvenOddTest {

	// Creating a list
	private EvenOdd evenOdd;

	@Before
	public void setUp() {
		// Instantiating the list
		evenOdd = new EvenOdd();

		// Adding some data to the list
		evenOdd.add(5);
		evenOdd.add(6);
		evenOdd.add(2);
		evenOdd.add(0);
		evenOdd.add(3);
		evenOdd.add(1);
		evenOdd.add(8);
		evenOdd.add(7);
		evenOdd.add(4);
		evenOdd.add(9);
	}

	/**
	 * This method tests the method which segregates even and odd elements in the linked list
	 */
	@Test
	public void testSegregate() {
		Assert.assertEquals(evenOdd.segregate().toString(), "[6, 2, 0, 8, 4, 5, 3, 1, 7, 9]");
	}
}
