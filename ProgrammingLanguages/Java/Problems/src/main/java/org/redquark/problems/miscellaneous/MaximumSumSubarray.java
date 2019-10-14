package org.redquark.problems.miscellaneous;

/**
 * Write an efficient program to find the sum of contiguous subarray within a
 * one-dimensional array of numbers which has the largest sum.
 * 
 * @author Anirudh Sharma
 *
 */
public class MaximumSumSubarray {

	public static void main(String[] args) {

		int[] a = { -2, -3, 4, -1, -2, 1, 5, -3 };
		int n = a.length;
		System.out.println(maxSubArraySum(a, n));
	}

	/**
	 * This method returns the maximum sum of contiguous sub array
	 */
	private static int maxSubArraySum(int[] a, int n) {

		// Current max
		int currentMax = a[0];
		// Final max
		int max = a[0];

		// Loop for each element in the array
		for (int i = 1; i < n; i++) {
			// Current max should be maximum of current element and current max plus current
			// element
			currentMax = Math.max(a[i], currentMax + a[i]);

			// Final max should be maximum of currentMax and max
			max = Math.max(max, currentMax);
		}

		return max;

	}
}
