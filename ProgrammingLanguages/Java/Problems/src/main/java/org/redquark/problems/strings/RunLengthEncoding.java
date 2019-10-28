package org.redquark.problems.strings;

import java.util.Scanner;

/**
 * Given an input string, write a function that returns the Run Length Encoded
 * string for the input string. For example, if the input string is
 * “wwwwaaadexxxxxx”, then the function should return “w4a3d1e1x6”.
 * 
 * @author Anirudh Sharma
 *
 */
public class RunLengthEncoding {

	public static void main(String[] args) {

		// Scanner instance to get the input from the user
		Scanner in = new Scanner(System.in);
		// String to be worked upon
		String s = in.next();
		// Closing the Scanner instance to avoid memory leaks
		in.close();

		// Length of the input String
		int length = s.length();

		// This will store the result
		StringBuilder result = new StringBuilder();

		// Loop through the entire String

		for (int i = 0; i < length; i++) {
			// Count of the ith character
			int count = 1;
			result.append(s.charAt(i));

			// Loop for each character
			while (i < length - 1 && s.charAt(i) == s.charAt(i + 1)) {
				count++;
				i++;
			}
			result.append(count);
		}

		System.out.println("Encoded string for " + s + " is : " + result.toString());
	}

}
