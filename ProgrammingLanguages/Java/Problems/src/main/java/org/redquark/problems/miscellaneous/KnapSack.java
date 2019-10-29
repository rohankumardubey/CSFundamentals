package org.redquark.problems.miscellaneous;

/**
 * Given weights and values of n items, put these items in a knapsack of
 * capacity W to get the maximum total value in the knapsack. In other words,
 * given two integer arrays val[0..n-1] and wt[0..n-1] which represent values
 * and weights associated with n items respectively. Also given an integer W
 * which represents knapsack capacity, find out the maximum value subset of
 * val[] such that sum of the weights of this subset is smaller than or equal to
 * W. You cannot break an item, either pick the complete item, or don’t pick it
 * (0-1 property).
 * 
 * @author Anirudh Sharma
 *
 */
public class KnapSack {

	public static void main(String[] args) {

		int[] value = { 60, 100, 120 };
		int[] weight = { 10, 20, 30 };
		int W = 50;
		int n = value.length;
		System.out.println(getMaxValue(W, weight, value, n));
	}

	private static int getMaxValue(int W, int[] weight, int[] value, int n) {

		// Temporary array that has to be built in bottom up manner
		int[][] K = new int[n + 1][W + 1];

		// Build table K[][] in bottom up manner
		for (int i = 0; i <= n; i++) {
			for (int w = 0; w <= W; w++) {
				if (i == 0 || w == 0) {
					K[i][w] = 0;
				} else if (weight[i - 1] <= w) {
					K[i][w] = Math.max(value[i - 1] + K[i - 1][w - weight[i - 1]], K[i - 1][w]);
				} else {
					K[i][w] = K[i - 1][w];
				}
			}
		}

		return K[n][W];
	}

}
