package org.redquark.problems.miscellaneous;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Given a range of numbers [l, r] and an integer q. The task is to count all
 * such number in the given range such that any digit of the number does not
 * match with any digit in its product with the given number q.
 * 
 * @author Anirudh Sharma
 *
 */
public class CountNumbersInRange {

	public static void main(String[] args) {

		// Scanner to read inputs from the user
		Scanner in = new Scanner(System.in);
		// Starting point of range
		int l = in.nextInt();
		// Ending point of the range
		int r = in.nextInt();
		// Number to be multiplied with
		int q = in.nextInt();

		// Closing the scanner to avoid memory leak
		in.close();

		System.out.println("Count: " + getCount(l, r, q));
	}

	/**
	 * This method returns the count which satisfies the condition given
	 */
	private static int getCount(int l, int r, int q) {
		// Counter
		int count = 0;

		// Loop for each element in the queue
		for (int i = l; i <= r; i++) {
			// Checks if the number is acceptable
			if (countInRange(i, q)) {
				count++;
			}
		}

		return count;
	}

	/**
	 * Helper method to check if the product contains any of the digit present in
	 * the original number
	 */
	private static boolean countInRange(int n, int q) {

		String product = Integer.toString(n * q);
		String originalNumber = Integer.toString(n);

		Set<Character> characterSet = new HashSet<>();

		// Storing each character of String representation of original number in a set
		for (int i = 0; i < originalNumber.length(); i++) {
			characterSet.add(originalNumber.charAt(i));
		}

		// Check if any character of the product lies in the original number
		for (int i = 0; i < product.length(); i++) {
			if (characterSet.contains(product.charAt(i))) {
				return false;
			}
		}
		return true;
	}

}
