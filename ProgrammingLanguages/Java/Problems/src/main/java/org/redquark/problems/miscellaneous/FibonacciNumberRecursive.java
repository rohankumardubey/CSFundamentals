package org.redquark.problems.miscellaneous;

import java.util.Scanner;

/**
 * @author Anirudh Sharma
 *
 */
public class FibonacciNumberRecursive {

	public static void main(String[] args) {

		// Scanner instance to read input from the user
		Scanner in = new Scanner(System.in);
		// Read the value of n
		int n = in.nextInt();
		// Close Scanner instance to avoid memory leaks
		in.close();

		System.out.println(n + "th Fibonacci number: " + nthFibonacciNumber(n));
	}

	/**
	 * This method calculates the nth Fibonacci number recursively
	 */
	private static int nthFibonacciNumber(int n) {

		if (n <= 1) {
			return n;
		}

		return nthFibonacciNumber(n - 1) + nthFibonacciNumber(n - 2);
	}

}
