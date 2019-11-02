package org.redquark.problems.miscellaneous;

/**
 * Given a matrix of integers, task is to find out number of positional
 * elements. A positional element is one which is either minimum or maximum in a
 * row or in a column.
 * 
 * @author Anirudh Sharma
 *
 */
public class CountPositionalElements {

	public static void main(String[] args) {

		int a[][] = new int[][] { { 1, 3, 4 }, { 5, 2, 9 }, { 8, 7, 6 } };
		int m = 3, n = 3;
		System.out.println("Numbr of positionals: " + countPositionals(a, m, n));

	}

	private static int countPositionals(int[][] matrix, int m, int n) {

		// rowMax[i] will store maximum of i-th row
		int[] rowMax = new int[m];
		// rowMin[i] will store minimum of i-th row
		int[] rowMin = new int[m];
		// colMax[i] will store maximum of i-th column
		int[] colMax = new int[n];
		// colMin[i] will store minimum of i-th column
		int[] colMin = new int[n];

		// Finding minimum and maximum in every row
		for (int i = 0; i < m; i++) {
			int rMin = Integer.MAX_VALUE;
			int rMax = Integer.MIN_VALUE;
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] < rMin) {
					rMin = matrix[i][j];
				}
				if (matrix[i][j] > rMax) {
					rMax = matrix[i][j];
				}
			}
			rowMax[i] = rMax;
			rowMin[i] = rMin;
		}

		// Find minimum and maximum in every column
		for (int j = 0; j < n; j++) {
			int cMin = Integer.MIN_VALUE;
			int cMax = Integer.MIN_VALUE;
			for (int i = 0; i < m; i++) {
				if (matrix[i][j] < cMin) {
					cMin = matrix[i][j];
				}
				if (matrix[i][j] > cMax) {
					cMax = matrix[i][j];
				}
			}
			colMax[j] = cMax;
			colMin[j] = cMin;
		}

		// Check for the positional element
		int count = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == rowMax[i] || matrix[i][j] == rowMin[i] || matrix[i][j] == colMax[j]
						|| matrix[i][j] == colMin[j]) {
					count++;
				}
			}
		}

		return count;
	}
}
