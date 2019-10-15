package org.redquark.problems.miscellaneous;

/**
 * Given two sorted arrays, a[] and b[], task is to find the median of these
 * sorted arrays, in O(log(min(n, m)), when n is the number of elements in the
 * first array, and m is the number of elements in the second array.
 * 
 * @author Anirudh Sharma
 *
 */
public class MedianOfSortedArraysOfDifferentLength {

	public static void main(String[] args) {

		int[] x = { 1, 3, 8, 9, 15 };
		int[] y = { 7, 11, 19, 21, 24, 25 };

		System.out.println("Median: " + findMedian(x, y));
	}

	/**
	 * This method returns the median of two sorted arrays of different lengths
	 */
	private static double findMedian(int[] a, int[] b) {

		// When the first array is bigger than the second one then we revert their order
		// This is necessary as we are going to perform binary search on the smaller
		// array
		if (a.length > b.length) {
			return findMedian(b, a);
		}

		// Individual lengths of two arrays
		int x = a.length;
		int y = b.length;

		// Start pointer
		int start = 0;
		// End pointer
		int end = x;

		// Performing binary search on the smaller array
		while (start <= end) {
			int partitionA = (start + end) / 2;
			int partitionB = (x + y + 1) / 2 - partitionA;

			// If partitionX is 0 which means there are no elements on the left of array a
			int maxLeftA = (partitionA == 0) ? Integer.MIN_VALUE : a[partitionA - 1];

			// If partitionX is equal to the length of the array which means there are no
			// elements on the right of array a
			int minRightA = (partitionA == x) ? Integer.MAX_VALUE : a[partitionA];

			// Similar cases of the second array
			int maxLeftB = (partitionB == 0) ? Integer.MIN_VALUE : b[partitionB - 1];
			int minRightB = (partitionB == y) ? Integer.MAX_VALUE : b[partitionB];

			if (maxLeftA <= minRightB && maxLeftB <= minRightA) {
				// This means we have partitioned at the right place
				if ((x + y) % 2 == 0) {
					return (double) (Math.max(maxLeftA, maxLeftB) + Math.min(minRightA, minRightB)) / 2;
				} else {
					return (double) Math.max(maxLeftA, maxLeftB);
				}
			} else if (maxLeftA > minRightB) {
				// We are too far on the right side. Go to the left side.
				end = partitionA - 1;
			} else {
				// We are too far on the left side. Go to the right side.
				start = partitionA + 1;
			}
		}

		// If we reach here then it means there is something wrong with the input
		throw new IllegalArgumentException();
	}
}
