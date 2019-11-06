package org.redquark.problems.miscellaneous;

/**
 * @author Anirudh Sharma
 *
 */
public class MinimumElementInRotatedArray {

	public static void main(String[] args) {

		int arr1[] = { 5, 6, 1, 2, 3, 4 };
		int n1 = arr1.length;
		System.out.println("The minimum element is " + findMinimumElement(arr1, 0, n1 - 1));

		int arr2[] = { 1, 2, 3, 4 };
		int n2 = arr2.length;
		System.out.println("The minimum element is " + findMinimumElement(arr2, 0, n2 - 1));

		int arr3[] = { 1 };
		int n3 = arr3.length;
		System.out.println("The minimum element is " + findMinimumElement(arr3, 0, n3 - 1));

		int arr4[] = { 1, 2 };
		int n4 = arr4.length;
		System.out.println("The minimum element is " + findMinimumElement(arr4, 0, n4 - 1));

		int arr5[] = { 2, 1 };
		int n5 = arr5.length;
		System.out.println("The minimum element is " + findMinimumElement(arr5, 0, n5 - 1));

		int arr6[] = { 5, 6, 7, 1, 2, 3, 4 };
		int n6 = arr6.length;
		System.out.println("The minimum element is " + findMinimumElement(arr6, 0, n6 - 1));

		int arr7[] = { 1, 2, 3, 4, 5, 6, 7 };
		int n7 = arr7.length;
		System.out.println("The minimum element is " + findMinimumElement(arr7, 0, n7 - 1));

		int arr8[] = { 2, 3, 4, 5, 6, 7, 8, 1 };
		int n8 = arr8.length;
		System.out.println("The minimum element is " + findMinimumElement(arr8, 0, n8 - 1));

		int arr9[] = { 3, 4, 5, 1, 2 };
		int n9 = arr9.length;
		System.out.println("The minimum element is " + findMinimumElement(arr9, 0, n9 - 1));
	}

	private static int findMinimumElement(int[] a, int low, int high) {

		// Base case - when the array is not rotated at all.
		if (high < low) {
			// Since the array is sorted so in this case first element will be the smallest
			return a[0];
		}

		// If there is only one element left
		if (high == low) {
			return a[low];
		}

		// Find the middle point
		int mid = low + (high - low) / 2;

		// Check if element mid+1 is itself a minimum element
		if (mid < high && a[mid + 1] < a[mid]) {
			return a[mid + 1];
		}

		// Check if element mid is itself a minimum element
		if (mid > low && a[mid - 1] > a[mid]) {
			return a[mid];
		}

		// Decide whether we go into left or right half
		if (a[high] > a[mid]) {
			return findMinimumElement(a, low, mid - 1);
		} else {
			return findMinimumElement(a, mid + 1, high);
		}
	}
}
