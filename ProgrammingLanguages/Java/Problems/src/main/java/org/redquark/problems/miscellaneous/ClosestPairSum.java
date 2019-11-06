package org.redquark.problems.miscellaneous;

/**
 * Given a sorted array and a number x, find a pair in array whose sum is
 * closest to x.
 * 
 * @author Anirudh Sharma
 *
 */
public class ClosestPairSum {

	public static void main(String[] args) {

		int a[] = { 10, 22, 28, 29, 30, 40 };
		int target = 54;

		findClosestPairSum(a, target);
	}

	/**
	 * This method finds the closest pair in an integer array whose sum is closest
	 * to a given value/target
	 */
	private static void findClosestPairSum(int[] a, int target) {

		// Final indexes of pair
		int x = 0;
		int y = 0;

		// Left and right indexes
		int l = 0;
		int r = a.length - 1;

		// Difference
		int difference = Integer.MAX_VALUE;

		// Loop through the array
		while (l < r) {
			// Check if this pair is closer than the current closest
			if (Math.abs(a[l] + a[r] - target) < difference) {
				// Updating the final indexes
				x = l;
				y = r;
				difference = Math.abs(a[l] + a[r] - target);
			}

			// If this pair has sum more than the target then move on to the smaller values
			if (a[l] + a[r] > target) {
				r--;
			} else {
				// Move to larger values
				l++;
			}
		}

		System.out.println("The closest pair is: " + a[x] + " and " + a[y]);
	}
}
