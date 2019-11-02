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

		int[] values = { 60, 100, 120 };
		int[] weights = { 10, 20, 30 };
		int W = 50;
		int n = values.length;
		System.out.println("Solution by Optimal Substrucure approach: " + optimalSubstructure(W, n, values, weights));
		System.out.println(
				"Solution by Overlapping Subproblems approach: " + overlappingSubproblems(W, weights, values, n));
	}

	/**
	 * This method finds the maximum value using the optimal substructure approach
	 */
	private static int optimalSubstructure(int capacity, int n, int[] values, int[] weights) {

		// Base case - where the capacity is zero or we do not have any more elements to
		// choose from
		if (capacity == 0 || n == 0) {
			return 0;
		}

		// Check for the weight of the last element
		// If the weight of the last element is less than the capacity of the KnapSack
		if (weights[n - 1] <= capacity) {
			// ... then we either include or exclude the item to get the maximum value
			return Math.max(values[n - 1] + optimalSubstructure(capacity - weights[n - 1], n - 1, values, weights),
					optimalSubstructure(capacity, n - 1, values, weights));
		} else {
			// ... else we ignore the item
			return optimalSubstructure(capacity, n - 1, values, weights);
		}
	}

	/**
	 * This method find the maximum value using the overlapping subproblems approach
	 */
	private static int overlappingSubproblems(int W, int[] weight, int[] value, int n) {

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
