package org.redquark.problems.miscellaneous;

import java.util.Scanner;

/**
 * Ugly numbers are numbers whose only prime factors are 2, 3 or 5. The sequence
 * 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, … shows the first 11 ugly numbers. By
 * convention, 1 is included.
 * 
 * Given a number n, the task is to find n’th Ugly number.
 * 
 * @author Anirudh Sharma
 *
 */
public class FindNthUglyNumber {

	public static void main(String[] args) {

		// Scanner instance to read input from the user
		Scanner in = new Scanner(System.in);
		// Read value of n - we need to find nth ugly number
		int n = in.nextInt();
		// Closing the instance to avoid memory leakage
		in.close();

		// Creating a lookup array
		int[] lookup = new int[n];

		// Indexes for each factor of 2, 3 and 5
		int i2 = 0;
		int i3 = 0;
		int i5 = 0;

		// Initialize three choices of the next ugly number
		int next2 = 2;
		int next3 = 3;
		int next5 = 5;

		// Initialized next ugly number
		int next = 1;

		// First number of the ugly number sequence
		lookup[0] = 1;

		// Iterate until n
		for (int i = 1; i < n; i++) {

			// Assigning the ith element in the lookup array with the minimum of next2,
			// next3 and next5
			next = Math.min(next2, Math.min(next3, next5));
			lookup[i] = next;

			if (next == next2) {
				i2++;
				next2 = lookup[i2] * 2;
			}

			if (next == next3) {
				i3++;
				next3 = lookup[i3] * 3;
			}

			if (next == next5) {
				i5++;
				next5 = lookup[i5] * 5;
			}
		}

		System.out.println(n + "th ugly number: " + next);
	}

}
