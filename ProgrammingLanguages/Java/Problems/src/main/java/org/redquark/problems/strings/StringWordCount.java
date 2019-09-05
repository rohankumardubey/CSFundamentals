package org.redquark.problems.strings;

import java.util.Scanner;

/**
 * This program counts the number of words in a sentence provided by the user
 * 
 * @author Anirudh Sharma
 *
 */
public class StringWordCount {

	public static void main(String[] args) {

		// Read a sentence from the user
		Scanner scanner = new Scanner(System.in);
		String sentence = scanner.nextLine();

		// Counter to store count of number of words
		int counter = 0;

		// Check if the entered string is not empty or null or blank
		if (sentence != null && !sentence.isBlank() && !sentence.isEmpty()) {
			// Set counter to 1
			counter = 1;

			// Loop until length of String
			for (int i = 0; i < sentence.length() - 1; i++) {

				// Check if the space/tab/new line is followed by a character
				// If this is the case, we will increment the counter
				if ((sentence.charAt(i) == ' ') && (sentence.charAt(i + 1) != ' ')) {
					counter++;
				}
			}
		}

		System.out.println("Count: " + counter);

		// Closing the scanner to avoid memory leak - IMPORTANT
		scanner.close();
	}

}
