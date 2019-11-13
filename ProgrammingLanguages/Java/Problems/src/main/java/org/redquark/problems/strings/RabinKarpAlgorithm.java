package org.redquark.problems.strings;

import java.util.Scanner;

/**
 * Rabin-Karp algorithm also slides the pattern one by one. But unlike the Naive
 * algorithm, Rabin Karp algorithm matches the hash value of the pattern with
 * the hash value of current substring of text, and if the hash values match
 * then only it starts matching individual characters. So Rabin Karp algorithm
 * needs to calculate hash values for following strings.
 * 
 * @author Anirudh Sharma
 *
 */
public class RabinKarpAlgorithm {

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

	private static void searchPattern(String text, String pattern) {

		// Number of characters in the alphabets
		int d = 256;
		// A prime number
		int q = 101;

		// Length of the text
		int n = text.length();
		// Length of the pattern
		int m = pattern.length();

		// Hash value of pattern
		int p = 0;
		// Hash value of text
		int t = 0;

		// Value of h will be (d^(m-1))%q
		int h = (int) (Math.pow(d, m - 1) % q);

		// Calculate the hash value of the pattern and first window of text
		for (int i = 0; i < m; i++) {
			p = (p * d + pattern.charAt(i)) % q;
			t = (t * d + text.charAt(i)) % q;
		}

		// Slide the pattern over text one by one - sliding window
		for (int i = 0; i <= n - m; i++) {
			// Check the hash values of current window of text
			// and pattern. If the hash values match then only
			// check for characters on by one
			if (p == t) {
				int j;
				// Check for characters one by one
				for (j = 0; j < m; j++) {
					if (text.charAt(i + j) != pattern.charAt(j)) {
						break;
					}
				}
				if (j == m) {
					System.out.println("Pattern found at index: " + i);
				}
			}

			// Calculate hash value for next window of text: Remove leading digit and add
			// trailing digit
			if (i < n - m) {
				t = (d * (t - text.charAt(i) * h) + text.charAt(i + m)) % q;
				// In case of negative value, we convert it to positive
				if (t < 0) {
					t += q;
				}
			}
		}

	}
}
