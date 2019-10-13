package org.redquark.problems.miscellaneous;

import java.util.Arrays;

/**
 * @author Anirudh Sharma
 *
 */
public class ReverseArray {

	public static void main(String[] args) {

		int[] arr = { 5, 4, 3, 2, 1 };

		// Sort iteratively
		System.out.println("Sort iteratively");
		iterative(arr);
		Arrays.stream(arr).forEach(System.out::println);

		// Sort recursively
		System.out.println("Sort recursively");
		recursive(arr, 0, arr.length - 1);
		Arrays.stream(arr).forEach(System.out::println);

	}

	/**
	 * This method is used to reverse the array using iterative approach
	 */
	private static void iterative(int[] arr) {

		// Initializing low and high pointer
		int low = 0;
		int high = arr.length - 1;

		// Loop until low reaches high
		while (low < high) {
			// Swapping the values at current low and current high
			int temp = arr[low];
			arr[low] = arr[high];
			arr[high] = temp;

			// Incrementing low to move one element forward
			low++;
			// Decrementing high to move one element backward
			high--;
		}
	}

	/**
	 * This method uses the recursive approach to reverse an array
	 */
	private static void recursive(int[] arr, int low, int high) {

		// Base condition
		if (low >= high) {
			return;
		}

		// Swap the elements at current low and current high
		int temp = arr[low];
		arr[low] = arr[high];
		arr[high] = temp;

		// Recursive call for the next elements in the forward and backward direction
		recursive(arr, low + 1, high - 1);
	}
}
