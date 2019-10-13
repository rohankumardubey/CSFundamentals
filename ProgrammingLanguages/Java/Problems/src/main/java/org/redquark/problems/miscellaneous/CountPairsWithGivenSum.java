package org.redquark.problems.miscellaneous;

import java.util.HashSet;
import java.util.Set;

/**
 * Write a program that, given an array A[] of n numbers and another number x,
 * determines whether or not there exist two elements in S whose sum is exactly
 * x.
 * 
 * @author Anirudh Sharma
 *
 */
public class CountPairsWithGivenSum {

	public static void main(String[] args) {

		// Array to be searched
		int[] arr = { 1, 5, 7, -1, 5 };
		int sum = 6;

		// Set to store elements of the array
		Set<Integer> set = new HashSet<>();

		int count = 0;

		for (int i = 0; i < arr.length; i++) {
			// Find the difference of given sum and the ith element
			int difference = sum - arr[i];
			// Check if difference is present in the set
			if (set.contains(difference)) {
				count++;
			}
			// Add the current element in the Set
			set.add(arr[i]);
		}

		System.out.println("Number of pairs: " + count);
	}

}
