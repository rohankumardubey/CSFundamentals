package org.redquark.problems.miscellaneous;

/**
 * There are n houses build in a line, each of which contains some value in it.
 * A thief is going to steal the maximal value of these houses, but he can’t
 * steal in two adjacent houses because owner of the stolen houses will tell his
 * two neighbour left and right side. What is the maximum stolen value.
 * 
 * @author Anirudh Sharma
 *
 */
public class MaximumPossibleStolenValue {

	public static void main(String[] args) {

		// Value array of houses
		int[] a = { 6, 7, 1, 3, 8, 2, 4 };
		// Total number of houses
		int n = a.length;

		System.out.println("Maximum loot: " + getMaximumValue(a, n));
	}

	/**
	 * This method returns the maximum loot value for a thief
	 */
	private static int getMaximumValue(int[] a, int n) {

		// Base condition = when there are no houses
		if (n == 0) {
			return 0;
		}

		// For a single house
		int x = a[0];
		if (n == 1) {
			return x;
		}

		// For two houses only
		int y = Math.max(a[0], a[1]);
		if (n == 2) {
			return y;
		}

		// Value of maximum loot
		int max = 0;

		// Loop for each house starting from third house (We have already covered cases
		// for n=1 and n=2)
		for (int i = 2; i < n; i++) {
			// Get the maximum of current loot and previous loot
			max = Math.max(a[i] + x, y);
			x = y;
			y = max;
		}

		// Return the maximum loot value
		return max;
	}
}
