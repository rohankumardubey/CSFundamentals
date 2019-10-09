package org.redquark.problems.miscellaneous;

import java.util.Arrays;

/**
 * A Wave form - arr[0] >= arr[1] <= arr[2] >= arr[3] <= arr[4]....
 * 
 * @author Anirudh Sharma
 *
 */
public class ArrayWaveForm {

	public static void main(String[] args) {

		// Array to be converted into waveform
		int[] a = { 10, 90, 49, 2, 1, 5, 23 };

		// Loop through the length of the array but traversing only even elements
		for (int i = 0; i < a.length; i = i + 2) {

			// Swap if current element is smaller than the previous
			if (i > 0 && a[i - 1] > a[i]) {
				swap(a, i - 1, i);
			}

			// Swap if the current element is small than the next
			if (i < a.length - 1 && a[i] < a[i + 1]) {
				swap(a, i, i + 1);
			}
		}

		// Printing the array
		Arrays.stream(a).forEach(System.out::println);
	}

	/**
	 * Helper method to swap the elements of array
	 */
	private static void swap(int[] a, int x, int y) {
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}

}
