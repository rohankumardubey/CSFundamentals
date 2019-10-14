package org.redquark.problems.miscellaneous;

import java.util.Scanner;

/**
 * Given a number n, write an efficient function to print all prime factors of
 * n. For example, if the input number is 12, then output should be “2 2 3”. And
 * if the input number is 315, then output should be “3 3 5 7”.
 * 
 * @author Anirudh Sharma
 *
 */
public class FindPrimeFactors {

	public static void main(String[] args) {

		// Scanner instance to take input from the user
		Scanner in = new Scanner(System.in);
		// Number for which we need to find prime factors
		int n = in.nextInt();
		// Closing Scanner instance to avoid memory leaks
		in.close();

		System.out.println("Prime factors of " + n + " are: " + getPrimeFactors(n));
	}

	/**
	 * This method returns the prime factors of the given number n
	 */
	private static String getPrimeFactors(int n) {

		// StringBuilder instance that will store each prime factor
		StringBuilder result = new StringBuilder();

		// Check the divisibility by the first prime number 2
		while (n % 2 == 0) {
			result.append(2).append(" ");
			n = n / 2;
		}

		// Check the divisibility by the next odd numbers starting from 3
		for (int i = 3; i <= Math.sqrt(n); i = i + 2) {
			while (n % i == 0) {
				result.append(i).append(" ");
				n = n / i;
			}
		}

		// If n is a prime number greater than 2 then return that prime number
		if (n > 2) {
			result.append(n);
		}

		return result.toString();
	}
}
