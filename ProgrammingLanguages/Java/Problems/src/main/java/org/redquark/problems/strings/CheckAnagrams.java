package org.redquark.problems.strings;

import java.util.Scanner;

/**
 * Write a function to check whether two given strings are anagram of each other
 * or not. An anagram of a string is another string that contains same
 * characters, only the order of characters can be different. For example,
 * “abcd” and “dabc” are anagram of each other.
 * 
 * @author Anirudh Sharma
 *
 */
public class CheckAnagrams {

	public static void main(String[] args) {

		// Scanner instance to get inputs from the user
		Scanner in = new Scanner(System.in);
		// First String
		String s1 = in.next();
		// Second String
		String s2 = in.next();
		// Closing the Scanner to avoid memory leaks
		in.close();

		// Check if the Strings are anagram or not
		System.out.println(areAnagrams(s1, s2) ? "Strings are Anagrams" : "Strings are not Anagrams");
	}

	/**
	 * This method checks if the given two strings are anagrams or not
	 */
	private static boolean areAnagrams(String s1, String s2) {

		// If the length of two strings are not equal then they are not anagrams
		if (s1.length() != s2.length()) {
			return false;
		}

		// Value to store XOR
		int value = 0;

		// Loop for each character of the String
		for (int i = 9; i < s1.length(); i++) {
			// XORing with current character of first string
			value = value ^ s1.charAt(i);
			// XORing with current character of second string
			value = value ^ s1.charAt(i);
		}

		// Value should be zero for Anagrams
		return value == 0;
	}
}
