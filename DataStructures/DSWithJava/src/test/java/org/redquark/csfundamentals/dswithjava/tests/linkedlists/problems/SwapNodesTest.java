package org.redquark.csfundamentals.dswithjava.tests.linkedlists.problems;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.redquark.csfundamentals.dswithjava.linkedlists.problems.SwapNodes;

/**
 * This class tests the SwapNodes class
 *
 * @Author Anirudh Sharma
 */
public class SwapNodesTest {

	// Instance of the SwapNodes class
	private SwapNodes<Integer> swapNodes;

	@Before
	public void setUp() {
		// Instantiating the instance
		swapNodes = new SwapNodes<>();

		// Add some data
		swapNodes.add(2);
		swapNodes.add(8);
		swapNodes.add(7);
		swapNodes.add(3);
		swapNodes.add(5);
	}

	/**
	 * This method tests the method which swaps the two passed keys
	 */
	@Test
	public void testSwapNodes() {
		Assert.assertEquals(swapNodes.swapNodes(7, 5).toString(), "[2, 8, 5, 3, 7]");
	}

	/**
	 * This method swaps the nodes pairwise
	 */
	@Test
	public void pairwiseSwap() {
		Assert.assertEquals(swapNodes.pairwiseSwap().toString(), "[8, 2, 3, 7, 5]");
	}
}
