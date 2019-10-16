package org.redquark.problems.miscellaneous;

import java.util.Scanner;

/**
 * A palindrome number is a number that is same after reverse. For example 545,
 * 151, 34543, 343, 171, 48984 are the palindrome numbers.
 * 
 * @author Anirudh Sharma
 *
 */
public class PalindromeNumber {

	public static void main(String[] args) {

		// Scanner instance to read input from the user
		Scanner in = new Scanner(System.in);
		// Read the number
		int n = in.nextInt();
		// Closing the instance to avoid memory leaks
		in.close();

		System.out.println(checkPalindrome(n) ? "Palindrome" : "Not Palindrome");

	}

	/**
	 * Method that checks if the specified number is Palindrome or not
	 */
	private static boolean checkPalindrome(int n) {

		// Base condition if the number is zero. Zero is considered as a Palindrome
		// number. And each single digit number is considered as a Palindrome
		if (n >= 0 && n < 10) {
			return true;
		}

		// Sum that will store the reverse of the original number
		int sum = 0;

		// Storing the value of n in temp variable so that we can have the n preserved
		// for our comparison later
		int temp = n;

		// Loop until we have temp greater than 0
		while (temp > 0) {

			// Getting the sum
			sum = sum * 10 + temp % 10;

			// Modifying temp for the next iteration
			temp = temp / 10;
		}

		// Return the boolean value on comparing original number with the reversed
		// number
		return n == sum;
	}

}
