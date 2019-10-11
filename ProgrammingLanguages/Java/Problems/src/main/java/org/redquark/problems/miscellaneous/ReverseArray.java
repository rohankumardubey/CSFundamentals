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

	private static void iterative(int[] arr) {
		int low = 0;
		int high = arr.length - 1;

		while (low < high) {
			int temp = arr[low];
			arr[low] = arr[high];
			arr[high] = temp;
			low++;
			high--;
		}
	}

	private static void recursive(int[] arr, int low, int high) {

		if (low >= high) {
			return;
		}

		int temp = arr[low];
		arr[low] = arr[high];
		arr[high] = temp;

		recursive(arr, low + 1, high - 1);
	}
}
