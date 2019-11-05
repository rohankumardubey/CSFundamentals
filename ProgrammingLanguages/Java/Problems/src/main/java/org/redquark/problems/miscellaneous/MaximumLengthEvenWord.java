package org.redquark.problems.miscellaneous;

import java.util.Scanner;

/**
 * Given a string of words separated by spaces. The task is to find the first
 * maximum length even word from the string. Eg: “You are given an array of n
 * numbers” The answer would be “an” and not “of” because “an” comes before
 * “of”.
 * 
 * Input: "this is a test string"
 * 
 * Output: string Even length words are this, is, test, string. Even maximum
 * length word is string.
 * 
 * Input: "geeksforgeeks is a platform for geeks"
 * 
 * Output: platform Only even length word is platform
 * 
 * @author Anirudh Sharma
 *
 */
public class MaximumLengthEvenWord {

	public static void main(String[] args) {

		// Scanner instance to read input from the user
		Scanner in = new Scanner(System.in);
		// String to operate on
		String s = in.nextLine();
		// Closing the Scanner to avoid memory leak
		in.close();

		System.out.println("Maximum even length word: " + findWord(s));

	}

	private static String findWord(String s) {

		// Length of the String
		int n = s.length();

		// Index
		int i = 0;

		// Length of the current word
		int currentLength = 0;

		// Maximum length
		int maxLength = 0;

		// Starting index of the maximum length word
		int startingIndex = -1;

		// Loop through the entire String
		while (i < n) {
			// If the current character is a space then it means the word has ended
			if (s.charAt(i) == ' ') {
				// Check if this is an even length word or not
				if (currentLength % 2 == 0) {
					// If yes, then compare it with the maximum length word found so far
					if (maxLength < currentLength) {
						maxLength = currentLength;
						// Updating the index of the maximum even length word
						startingIndex = i - currentLength;
					}
				}

				// Set currentLength to 0 for the next word
				currentLength = 0;
			} else {
				// Update the length of the current word
				currentLength++;
			}
			i++;
		}

		// Check the length of the last word
		if (currentLength % 2 == 0) {
			if (maxLength < currentLength) {
				maxLength = currentLength;
				startingIndex = i - currentLength;
			}
		}

		// If no even length word is present then return empty String
		if (startingIndex == -1) {
			return "";
		}

		// Return the maximum even length word
		return s.substring(startingIndex, startingIndex + maxLength);
	}
}
