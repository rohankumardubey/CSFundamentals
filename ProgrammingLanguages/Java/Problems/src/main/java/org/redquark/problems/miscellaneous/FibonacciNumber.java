package org.redquark.problems.miscellaneous;

import java.util.Scanner;

/**
 * Find nth Fibonacci number
 * 
 * @author Anirudh Sharma
 *
 */
public class FibonacciNumber {

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
	 * This method returns the nth Fibonacci number
	 */
	private static int nthFibonacciNumber(int n) {

		// First two terms of Fibonacci series
		int a = 0;
		int b = 1;

		if (n == 0) {
			return a;
		}

		if (n == 1) {
			return b;
		}

		int c;
		for (int i = 2; i <= n; i++) {
			c = a + b;
			a = b;
			b = c;
		}

		return b;
	}

}
