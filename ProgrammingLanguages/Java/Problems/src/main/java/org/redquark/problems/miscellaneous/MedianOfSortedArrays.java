package org.redquark.problems.miscellaneous;

import java.util.Arrays;

/**
 * @author Anirudh Sharma
 */
public class MedianOfSortedArrays {

	public static void main(String[] args) {

		int[] a = { 1, 12, 15, 26, 38 };
		int[] b = { 2, 13, 17, 30, 45 };

		System.out.println("Median: " + getMedian(a, b, a.length));
	}

	/**
	 * This method returns the median of two sorted arrays
	 */
	private static int getMedian(int[] a, int[] b, int n) {

		// Base conditions
		if (n <= 0) {
			return -1;
		}
		if (n == 1) {
			return (a[0] + b[0]) / 2;
		}
		if (n == 2) {
			return (Math.max(a[0], b[0]) + Math.min(a[1], b[1])) / 2;
		}

		// Get the median of first array
		int ma = median(a, n);
		// Get the median of second array
		int mb = median(b, n);

		// If medians are equal then we can return either one of them
		if (ma == mb) {
			return ma;
		}

		// If ma < mb then median must exist in a[ma...n] and b[0...mb]
		if (ma < mb) {
			if (n % 2 == 0) {
				return getMedian(Arrays.copyOfRange(a, n / 2 - 1, n), b, n - n / 2 + 1);
			}
			return getMedian(Arrays.copyOfRange(a, n / 2, n), b, n - n / 2);
		}

		// If ma > mb then median must exist in a[0...ma] and b[mb...n]
		if (n % 2 == 0) {
			return getMedian(Arrays.copyOfRange(b, n / 2 - 1, n), a, n - n / 2 + 1);
		}
		return getMedian(Arrays.copyOfRange(b, n / 2, n), a, n - n / 2);
	}

	/**
	 * This method calculates the median of the individual arrays
	 */
	private static int median(int[] arr, int n) {
		// Check if the array has even number of elements
		if (n % 2 == 0) {
			return (arr[n / 2] + arr[n / 2 - 1]) / 2;
		} else {
			return arr[n / 2];
		}
	}
}
