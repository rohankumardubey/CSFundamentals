package org.redquark.problems.miscellaneous;

/**
 * @author Anirudh Sharma
 *
 */
public class PrintItemsInAKnapSack {

	public static void main(String[] args) {

		int val[] = { 60, 100, 120 };
		int wt[] = { 10, 20, 30 };
		int W = 50;
		int n = val.length;

		printKnapSack(W, n, val, wt);
	}

	private static void printKnapSack(int C, int n, int[] values, int[] weights) {

		// Temporary array that will be built in bottom up manner
		int[][] K = new int[n + 1][C + 1];

		// Build table in bottom up manner
		for (int i = 0; i <= n; i++) {
			for (int w = 0; w <= C; w++) {
				if (i == 0 || w == 0) {
					K[i][w] = 0;
				} else if (weights[i - 1] <= w) {
					K[i][w] = Math.max(values[i - 1] + K[i - 1][w - weights[i - 1]], K[i - 1][w]);
				} else {
					K[i][w] = K[i - 1][w];
				}
			}
		}

		// Stores the result of KnapSack
		int result = K[n][C];
		System.out.println(result);

		int w = C;
		for (int i = n; i > 0 && result > 0; i--) {

			// Either the result comes from the top (K[i-1][w]) or from (val[i-1] + K[i-1]
			// [w-wt[i-1]]) as in Knapsack table. If it comes from the latter one/ it means
			// the item is included.
			if (result == K[i - 1][w]) {
				continue;
			} else {
				// This item is included
				System.out.print(weights[i - 1] + " ");
				// Since the weight is included its value will be deducted
				result = result - values[i - 1];
				w = w - weights[i - 1];
			}
		}
	}
}
