package org.redquark.problems.miscellaneous;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Given an array of numbers, arrange them in a way that yields the largest
 * value. For example, if the given numbers are {54, 546, 548, 60}, the
 * arrangement 6054854654 gives the largest value. And if the given numbers are
 * {1, 34, 3, 98, 9, 76, 45, 4}, then the arrangement 998764543431 gives the
 * largest value.
 * 
 * @author Anirudh Sharma
 *
 */
public class FormBiggestNumber {

	public static void main(String[] args) {

		// Input array of numbers
		int[] input = { 01, 34, 3, 98, 9, 76, 45, 4 };

		// List that will store the integer representation of numbers
		List<String> numbers = new ArrayList<>(input.length);

		// Add all the integers from input array to the List of String
		for (int i = 0; i < input.length; i++) {
			numbers.add(Integer.toString(input[i]));
		}

		// Sort the elements in the list using custom comparator
		Collections.sort(numbers, new Comparator<String>() {

			@Override
			public int compare(String x, String y) {

				// Form combination of Strings
				String XY = x + y;
				String YX = y + x;

				// sort the String elements
				return XY.compareTo(YX) > 0 ? -1 : 1;
			}
		});

		// This StringBuilder instance will store the final output
		StringBuilder sb = new StringBuilder();
		// Loop through each element of the List
		for (String s : numbers) {
			// Append the current element
			sb.append(s);
		}

		System.out.println(sb.toString());
	}

}
