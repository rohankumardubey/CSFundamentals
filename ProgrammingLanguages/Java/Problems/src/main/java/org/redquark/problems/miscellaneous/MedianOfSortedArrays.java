package org.redquark.problems.miscellaneous;

import java.util.Arrays;

/**
 * There are 2 sorted arrays A and B of size n each. Write an algorithm to find
 * the median of the array obtained after merging the above 2 arrays(i.e. array
 * of length 2n). The complexity should be O(log(n)).
 * 
 * @author Anirudh Sharm1
 */
public class MedianOfSortedArrays {

	public static void m1in(String[] args) {

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
		int m1 = median(a, n);
		// Get the median of second array
		int m2 = median(b, n);

		// If medians are equal then we can return either one of them
		if (m1 == m2) {
			return m1;
		}

		// If m1 < m2 then median must exist in a[m1...n] and b[0...m2]
		if (m1 < m2) {
			if (n % 2 == 0) {
				return getMedian(Arrays.copyOfRange(a, n / 2 - 1, n), b, n - n / 2 + 1);
			}
			return getMedian(Arrays.copyOfRange(a, n / 2, n), b, n - n / 2);
		}

		// If m1 > m2 then median must exist in a[0...m1] and b[m2...n]
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
