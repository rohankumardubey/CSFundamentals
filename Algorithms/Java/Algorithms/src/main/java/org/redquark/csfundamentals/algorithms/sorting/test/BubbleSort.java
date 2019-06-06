package org.redquark.csfundamentals.algorithms.sorting.test;

/**
 * @Author Anirudh Sharma
 */
public class BubbleSort {

	public static <T extends Comparable<T>> T[] sort(T[] arr) {

		// Length of the array
		int length = arr.length;

		// Outer loop for each pass
		for (int i = 0; i < length - 1; i++) {

			// Loop for each element in the array - This will be done for each pass (iteration)
			for (int j = 0; j < length - i - 1; j++) {

				// Swap if the elements are in the wrong order
				if (arr[j].compareTo(arr[j + 1]) > 0) {
					T temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		return arr;
	}

	public static <T extends Comparable<T>> T[] optimizedSort(T[] arr) {

		// Length of the array
		int length = arr.length;

		// Flag to check if further swap is needed
		boolean swapped = true;

		while (swapped) {

			// Setting flag to false to avoid unnecessary traversal
			swapped = false;

			// Loop for each element in the array - This will be done for each pass (iteration)
			for (int i = 0; i < length - 1; i++) {

				// Swap if the elements are in the wrong order
				if (arr[i].compareTo(arr[i + 1]) > 0) {

					T temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;

					// Since the elements were swapped, it means more iterations are needed.
					// Hence setting the flag to true
					swapped = true;
				}
			}
		}
		return arr;
	}
}
