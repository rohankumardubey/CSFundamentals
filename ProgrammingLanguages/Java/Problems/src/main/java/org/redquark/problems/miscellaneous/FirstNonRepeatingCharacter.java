package org.redquark.problems.miscellaneous;

import java.util.Scanner;

/**
 * @author Anirudh Sharma
 *
 */
public class FirstNonRepeatingCharacter {

	public static void main(String[] args) {

		// Scanner object to take input from the user
		Scanner in = new Scanner(System.in);

		// String to search
		String s = in.next();

		// Closing the Scanner to avoid memory leakage
		in.close();

		// Converting the String to lower case
		s = s.toLowerCase();

		// Loop for the length of the String for each character
		for (Character c : s.toCharArray()) {
			// If the first index of the character is also the last index of that character
			// then it means this character is not repeating
			if (s.indexOf(c) == s.lastIndexOf(c)) {
				// Print the character and break the loop
				System.out.println(s.indexOf(c));
				break;
			}
		}
	}
}
