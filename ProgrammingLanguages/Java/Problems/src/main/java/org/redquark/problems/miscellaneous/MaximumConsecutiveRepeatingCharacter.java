package org.redquark.problems.miscellaneous;

import java.util.Scanner;

/**
 * @author Anirudh Sharma
 *
 */
public class MaximumConsecutiveRepeatingCharacter {

	public static void main(String[] args) {
		
		// Scanner object to read data from the user
		Scanner in = new Scanner(System.in);
		// String to be searched
		String s = in.next();
		// Closing scanner to avoid memory leaks
		in.close();
		
		// Maximum count
		int count = 0;
		// Count that will store the current count of a character
		int currentCount = 1;
		// Character with maximum consecutive counts
		char result = s.charAt(0);
		
		for (int i = 0; i < s.length() - 1; i++) {
			
			// If current character matches with the next
			if(i < s.length() - 1 && s.charAt(i) == s.charAt(i+1)) {
				// Increment the count of current character
				currentCount++;
			} else { // If the current character does not match with the next, update the result and its count
				if(currentCount > count) {
					count = currentCount;
					result = s.charAt(i);
				}
				currentCount = 1;
			}
		}

		System.out.println("Maximum consecutive repeating character: " + result);
	}

}
