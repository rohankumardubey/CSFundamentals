package org.redquark.problems.strings;

import java.util.Scanner;

/**
 * Given String str and an integer k, find the lexicographically smallest and
 * largest substring of length k
 * 
 * Lexicographically order, also called as alphabetical order or dictionary
 * order,
 * 
 * A < B <... < Y < Z < a < b <.. < y < z
 * 
 * @author Anirudh Sharma
 *
 */
public class LargestAndSmallestSubstrings {

	public static void main(String[] args) {

		// Scanner instance to read input from the user
		Scanner in = new Scanner(System.in);
		// String to be worked upon
		String s = in.nextLine();
		// Size of substring
		int k = in.nextInt();
		// Closing scanner to avoid memory leak
		in.close();

		// Finding the largest and smallest substrings of a given size
		findLargestAndSmallestSubstrings(s, k);

	}

	/**
	 * This method returns the maximum and minimum substrings of the size k from the
	 * given string s
	 */
	private static void findLargestAndSmallestSubstrings(String s, int k) {

		// Current String
		String currentString = s.substring(0, k);

		// Lexicographically largest String
		String largest = currentString;

		// Lexicographically smallest String
		String smallest = currentString;

		// Iterate through the remaining string
		for (int i = k; i < s.length(); i++) {
			currentString = currentString.substring(1, k) + s.charAt(i);
			// Comparing with the current largest String
			if (currentString.compareTo(largest) > 0) {
				largest = currentString;
			}
			// Comparing with the current smallest String
			if (currentString.compareTo(smallest) < 0) {
				smallest = currentString;
			}
		}

		// Printing both the strings
		System.out.println("Largest substring: " + largest);
		System.out.println("Smallest substring: " + smallest);
	}
}
