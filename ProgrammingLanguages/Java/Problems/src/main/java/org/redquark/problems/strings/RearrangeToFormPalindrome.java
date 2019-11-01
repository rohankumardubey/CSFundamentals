package org.redquark.problems.strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Given a string, Check if characters of the given string can be rearranged to
 * form a palindrome.
 * 
 * For example characters of “geeksogeeks” can be rearranged to form a
 * palindrome “geeksoskeeg”, but characters of “geeksforgeeks” cannot be
 * rearranged to form a palindrome.
 * 
 * A set of characters can form a palindrome if at most one character occurs odd
 * number of times and all characters occur even number of times.
 * 
 * @author Anirudh Sharma
 *
 */
public class RearrangeToFormPalindrome {

	public static void main(String[] args) {

		// Scanner instance to read input from the user
		Scanner in = new Scanner(System.in);
		// Read input string
		String s = in.nextLine();
		// Close the scanner to avoid memory leaks
		in.close();

		System.out.println("Is Palindrome possible: " + checkIfPalindromeCanBeMade(s));
	}

	/**
	 * This method checks if a Palindrome String can be made from the given String
	 */
	private static boolean checkIfPalindromeCanBeMade(String s) {

		// Create a List to store all the characters in a String
		List<Character> characters = new ArrayList<>();

		// For each character in the input String, remove the character if already
		// present else add it
		for (int i = 0; i < s.length(); i++) {
			// Current character
			char c = s.charAt(i);
			// Check if the character is already present in the List
			if (characters.contains(c)) {
				// Remove the character
				characters.remove((Character) c);
			} else {
				// Else add it
				characters.add(c);
			}
		}

		// If character length is even list is expected to be empty
		// or if character length is odd list size is expected to be 1
		if ((s.length() % 2 == 0 && characters.isEmpty()) || (s.length() % 2 == 1 && characters.size() == 1)) {
			return true;
		} else {
			return false;
		}
	}
}
