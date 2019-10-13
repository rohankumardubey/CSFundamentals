package org.redquark.problems.miscellaneous;

import java.util.Scanner;

/**
 * @author Anirudh Sharma
 *
 */
public class WaysToReachNthStair {

	public static void main(String[] args) {

		// Scanner instance to read inputs from the user
		Scanner in = new Scanner(System.in);
		// Number of stairs
		int n = in.nextInt();
		// Number of stairs can climb once
		int m = in.nextInt();
		// Closing the Scanner instance to avoid memory leaks
		in.close();

		System.out.println("Number of ways to reach " + n + "th stair when a person can climb " + m
				+ " stairs at a time is: " + countWays(n + 1, m));
	}

	/**
	 * This method returns the count ways to reach to the nth stair while climbing m
	 * stairs at a time
	 */
	private static int countWays(int n, int m) {

		// Result array
		int[] result = new int[n];

		// Initialize first two elements of the array - just like we do in finding the
		// nth Fibonacci number
		result[0] = 1;
		result[1] = 1;

		// Loop until we reach for the nth stair
		for (int i = 2; i < n; i++) {
			// Setting the ith value to zero
			result[i] = 0;
			// Count the ways to reach to the ith stair
			for (int j = 1; j <= m && j <= i; j++) {
				result[i] = result[i] + result[i - j];
			}
		}

		return result[n - 1];
	}
}
