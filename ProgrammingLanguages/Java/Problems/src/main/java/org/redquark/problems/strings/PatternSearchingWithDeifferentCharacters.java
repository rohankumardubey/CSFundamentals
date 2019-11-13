package org.redquark.problems.strings;

import java.util.Scanner;

/**
 * Consider a situation where all characters of pattern are different. Can we
 * modify the original Naive String Matching algorithm so that it works better
 * for these types of patterns?
 * 
 * @author Anirudh Sharma
 *
 */
public class PatternSearchingWithDeifferentCharacters {

	public static void main(String[] args) {

		// Scanner instance to read inputs from the user
		Scanner in = new Scanner(System.in);
		// Text to be searched in
		String text = in.next();
		// Pattern to be searched
		String pattern = in.next();
		// Close the scanner to avoid memory loss
		in.close();

		// Search the pattern
		searchPattern(text, pattern);
	}

	/**
	 * This method searches a pattern with distinct characters in a given text by
	 * Sliding Window Method.
	 */
	private static void searchPattern(String text, String pattern) {

		// Length of the text
		int n = text.length();
		// Length of the pattern
		int m = pattern.length();

		// Index for the text
		int i = 0;

		while (i <= n - m) {

			// Index for the pattern
			int j;

			// For the current index i, check for the pattern match
			for (j = 0; j < m; j++) {
				// Compare the characters
				if (text.charAt(i + j) != pattern.charAt(j)) {
					break;
				}
			}

			// If the count of consecutive characters is equal to the characters in the
			// pattern
			if (j == m) {
				System.out.println("Pattern found at index: " + i);
				i = i + m;
			} else if (j == 0) {
				i = i + 1;
			} else {
				// Slide the pattern by j
				i = i + j;
			}
		}
	}
}
