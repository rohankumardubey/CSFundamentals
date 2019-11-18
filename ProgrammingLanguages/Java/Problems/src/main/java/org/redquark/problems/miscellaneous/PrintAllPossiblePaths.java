package org.redquark.problems.miscellaneous;

/**
 * The problem is to print all the possible paths from top left to bottom right
 * of a mXn matrix with the constraints that from each cell you can either move
 * only to right or down.
 * 
 * @author Anirudh Sharma
 *
 */
public class PrintAllPossiblePaths {

	public static void main(String[] args) {

		int m = 2;
		int n = 3;
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 } };
		int maxLengthOfPath = m + n - 1;

		printPaths(matrix, m, n, 0, 0, new int[maxLengthOfPath], 0);
	}

	/**
	 * Added the code to print the paths while moving from top left to the bottom
	 * right corner of an mXn matrix
	 */
	private static void printPaths(int[][] matrix, int m, int n, int i, int j, int[] paths, int index) {

		paths[index] = matrix[i][j];

		// Reach to the bottom of the matrix so we are left with only option to move
		// right
		if (i == m - 1) {
			for (int k = j + 1; k < n; k++) {
				paths[index + k - j] = matrix[i][k];
			}
			for (int l = 0; l < index + n - j; l++) {
				System.out.print(paths[l] + " ");
			}
			System.out.println();
			return;
		}

		// Reach to the rightward corner of the matrix so the only option is to move
		// down
		if (j == n - 1) {
			for (int k = i + 1; k < m; k++) {
				paths[index + k - i] = matrix[k][j];
			}
			for (int l = 0; l < index + m - i; l++) {
				System.out.print(paths[l] + " ");
			}
			System.out.println();
			return;
		}

		// Print all the paths that are possible after moving down
		printPaths(matrix, m, n, i + 1, j, paths, index + 1);

		// Print all the paths that are possible after moving right
		printPaths(matrix, m, n, i, j + 1, paths, index + 1);
	}
}
