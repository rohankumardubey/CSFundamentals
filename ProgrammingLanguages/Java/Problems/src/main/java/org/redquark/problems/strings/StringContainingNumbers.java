package org.redquark.problems.strings;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an array of numbers, the task is to print those numbers in ascending
 * order separated by commas which have 1, 2 and 3 in their digits. If no number
 * containing digits 1, 2, and 3 present then print -1.
 * 
 * @author Anirudh Sharma
 *
 */
public class StringContainingNumbers {

	public static void main(String[] args) {

		// The array to be searched
		int[] numbers = { 123, 1232, 456, 234, 32145 };

		// This list will contain the numbers which contain 1, 2 and 3
		List<Integer> finalList = new LinkedList<>();

		// Check for each number in the array
		for (int i = 0; i < numbers.length; i++) {
			if (containingOneTwoOrThree(numbers[i])) {
				finalList.add(numbers[i]);
			}
		}

		// Sort the numbers
		Collections.sort(finalList);

		// StringBuilder instance to store the output
		StringBuilder result = new StringBuilder();
		// Loop for the entire output list
		for (Integer i : finalList) {
			result.append(i).append(" ");
		}

		System.out.println(result.length() > 0 ? result.toString() : "-1");
	}

	/**
	 * Utility method to check if the number contains 1, 2 and 3
	 */
	private static boolean containingOneTwoOrThree(int n) {

		String s = Integer.toString(n);
		if (s.contains("1") && s.contains("2") && s.contains("3")) {
			return true;
		}
		return false;
	}
}
