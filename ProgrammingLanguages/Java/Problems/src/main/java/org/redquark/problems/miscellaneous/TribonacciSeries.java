package org.redquark.problems.miscellaneous;

import java.util.Scanner;

/**
 * The tribonacci series is a generalization of the Fibonacci sequence where
 * each term is the sum of the three preceding terms.
 * 
 * The Tribonacci Sequence : 0, 0, 1, 1, 2, 4, 7, 13, 24, 44, 81, 149, 274, 504,
 * 927, 1705, 3136, 5768, 10609, 19513, 35890, 66012, 121415, 223317, 410744,
 * 755476, 1389537, 2555757, 4700770, 8646064, 15902591, 29249425, 53798080,
 * 98950096, 181997601, 334745777, 615693474, 1132436852… so on
 * 
 * @author Anirudh Sharma
 *
 */
public class TribonacciSeries {

	public static void main(String[] args) {

		// Scanner instance to read input from the user
		Scanner in = new Scanner(System.in);
		// Nth term
		int n = in.nextInt();
		// Close the Scanner instance to avoid memory leaks
		in.close();

		System.out.println(n + "th Tribonacci number: " + findTribonacci(n));
	}

	/**
	 * This method returns the nth Tribonacci number
	 */
	private static int findTribonacci(int n) {

		// Check if the value of n is negative
		if (n < 0) {
			return 0;
		}

		// Initialize first three numbers
		int a = 0;
		int b = 0;
		int c = 1;

		if (n <= 2) {
			return 0;
		}

		// Loop until we reach the nth Tribonacci number
		for (int i = 3; i < n; i++) {
			int temp = a + b + c;
			a = b;
			b = c;
			c = temp;
		}

		return c;
	}
}
