package org.redquark.problems.miscellaneous;

import java.util.Scanner;

/**
 * Given a binary string, that is it contains only 0s and 1s. We need to make
 * this string a sequence of alternate characters by flipping some of the bits,
 * our goal is to minimize the number of bits to be flipped.
 * 
 * @author Anirudh Sharma
 *
 */
public class FlipBinaryStringAlternatively {

	public static void main(String[] args) {

		// Scanner instance to read input from the user
		Scanner in = new Scanner(System.in);
		// Input string
		String s = in.next();
		// Closing Scanner to avoid memory leaks
		in.close();

		// Minimum of the flip is the required value
		System.out.println("Minimum flips required: " + Math.min(getNumberOfFlips(s, '0'), getNumberOfFlips(s, '1')));
	}

	/**
	 * This method will return the number of flips required
	 */
	private static int getNumberOfFlips(String s, char c) {

		// Initialize the flip counter
		int flipCount = 0;
		// Loop for each character of the input String
		for (int i = 0; i < s.length(); i++) {
			// If the current character is not required as expected then we need to flip
			if (s.charAt(i) != c) {
				// We will then increment the flip counter
				flipCount++;
			}
			// Reverse the expected character value
			c = flip(c);
		}

		// Return the flip count value
		return flipCount;
	}

	/**
	 * This method just flips the value based on the character passed
	 */
	private static char flip(char c) {
		return (c == '0' ? '1' : '0');
	}
}
