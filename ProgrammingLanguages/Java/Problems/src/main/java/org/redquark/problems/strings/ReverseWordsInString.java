package org.redquark.problems.strings;

import java.util.Scanner;

/**
 * @author Anirudh Sharma
 *
 */
public class ReverseWordsInString {

	public static void main(String[] args) {

		// Scanner instance to get the input from the user
		Scanner in = new Scanner(System.in);
		// String to be reversed
		String sentence = in.nextLine();
		// Closing the Scanner to avoid memory leakage
		in.close();

		// Converting all multiple spaces to single spaces
		sentence = sentence.trim().replaceAll(" +", " ");

		// Split the string by space(s)
		String[] a = sentence.split(" ");

		// StringBuffer to store the result
		StringBuffer result = new StringBuffer();

		// Iterate through the array
		for (int i = a.length - 1; i >= 0; i--) {
			result.append(a[i]).append(" ");
		}

		// Final result
		String finalResult = result.toString();

		System.out.println(finalResult.substring(0, finalResult.length() - 1));
	}

}
