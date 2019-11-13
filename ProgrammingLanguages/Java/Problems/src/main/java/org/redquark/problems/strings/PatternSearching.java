package org.redquark.problems.strings;

import java.util.Scanner;

/**
 * Given a text txt[0..n-1] and a pattern pat[0..m-1], write a function
 * search(char pat[], char txt[]) that prints all occurrences of pat[] in txt[].
 * You may assume that n > m.
 * 
 * @author Anirudh Sharma
 *
 */
public class PatternSearching {

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
	 * This method searches the pattern in the string by sliding one character at a
	 * time. This is called Sliding Window Method.
	 */
	private static void searchPattern(String text, String pattern) {

		// Get the length of the text
		int n = text.length();
		// Get the length of the pattern
		int m = pattern.length();

		// A loop to slide pattern one by one
		for (int i = 0; i <= n - m; i++) {
			// This will count the number of consecutive characters which are equal to the
			// consecutive characters in the text.
			int count = 0;
			for (int j = 0; j < m; j++) {
				// For the current character i, check for the pattern match
				if (text.charAt(i + j) != pattern.charAt(j)) {
					// If the pattern does not match then break the inner loop
					break;
				}
				// Increment the consecutive matched character count
				count++;
			}
			// If the count is equal to the number of characters in the pattern, it means we
			// have found the entire pattern in the text
			if (count == m) {
				System.out.println("Pattern is found at index: " + i);
			}
		}
	}
}
