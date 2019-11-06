package org.redquark.problems.strings;

import java.util.Scanner;

/**
 * @author Anirudh Sharma
 *
 */
public class RemoveAdjacentDuplicates {

	public static void main(String[] args) {

		// Scanner instance to read input from the user
		Scanner in = new Scanner(System.in);
		// Read the string to work upon
		String s = in.next();
		// Close the Scanner to avoid memory leak
		in.close();

		System.out.println("Final string: " + remove(s));
	}

	private static String remove(String s) {

		// Last removed character
		char lastRemoved = '\0';

		return remove(s, lastRemoved);
	}

	private static String remove(String s, char lastRemoved) {

		// If the length of the String is 0 or 1, return the String
		if (s.length() == 0 || s.length() == 1) {
			return s;
		}

		// Remove leftmost same characters and recur for remaining string
		if (s.charAt(0) == s.charAt(1)) {
			lastRemoved = s.charAt(0);
			while (s.length() > 1 && s.charAt(0) == s.charAt(1)) {
				s = s.substring(1, s.length());
			}
			s = s.substring(1, s.length());
			return remove(s, lastRemoved);

		}

		// If we reach at this point, this means first character is definitely different
		// from its adjacent
		// Ignore first character and recursively remove characters from the remaining
		// string
		String remainingString = remove(s.substring(1, s.length()), lastRemoved);

		// Check if the first character of the remaining string matches with the first
		// character of the original String
		if (remainingString.length() != 0 && remainingString.charAt(0) == s.charAt(0)) {
			lastRemoved = s.charAt(0);
			// Remove first character
			return remainingString.substring(1, remainingString.length());
		}

		// If remaining string becomes empty and last removed character is same as the
		// first character of the original string
		if (remainingString.length() == 0 && lastRemoved == s.charAt(0)) {
			return remainingString;
		}

		// If the first two characters of the original string and remaining string do
		// not match, append first character of original string before the first
		// character of the remaining string
		return s.charAt(0) + remainingString;
	}
}
