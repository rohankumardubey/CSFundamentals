package org.redquark.problems.miscellaneous;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Given a string, find the first non-repeating character in it. For example, if
 * the input string is “GeeksforGeeks”, then output should be ‘f’ and if input
 * string is “GeeksQuiz”, then output should be ‘G’.
 * 
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

		System.out.println(
				"First non repeating character in the string: " + s + " is => " + getFirstNonRepeatingCharacter(s));
	}

	/**
	 * This method returns the first non-repeating character in the given String
	 */
	private static char getFirstNonRepeatingCharacter(String s) {

		// Map to store the character and its frequency in the given String
		Map<Character, Integer> countMap = new LinkedHashMap<>();

		// Loop through the entire String character by character
		for (int i = 0; i < s.length(); i++) {
			// Find the current character
			char c = s.charAt(i);

			// Check if the character is already present in the Map
			if (countMap.containsKey(c)) {
				// Get the current count of 'c'
				int currentCount = countMap.get(c);
				// Increment the current count by 1 and update the map
				countMap.put(c, currentCount + 1);
			} else {
				// If the current character is encountered for the first time
				countMap.put(c, 1);
			}
		}

		// Loop through the entire map to find the first character whose count is 1
		for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
			// Check if the value of current entry object is 1
			if (entry.getValue() == 1) {
				// Return the corresponding key
				return entry.getKey();
			}
		}

		// If all the characters are repeating then return -1
		return '\u0000';
	}
}
