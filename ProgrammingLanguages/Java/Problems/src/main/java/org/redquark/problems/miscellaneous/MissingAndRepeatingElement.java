package org.redquark.problems.miscellaneous;

/**
 * Given an unsorted array of size n. Array elements are in the range from 1 to
 * n. One number from set {1, 2, …n} is missing and one number occurs twice in
 * the array. Find these two numbers.
 * 
 * @author Anirudh Sharma
 *
 */
public class MissingAndRepeatingElement {

	public static void main(String[] args) {

		int a[] = { 7, 3, 4, 5, 5, 6, 2 };
		findMissingAndRemainingElement(a);
	}

	/**
	 * This method finds the missing and repeating elements in the given array
	 */
	private static void findMissingAndRemainingElement(int[] a) {

		// Loop through the entire array
		for (int i = 0; i < a.length; i++) {
			// Finding the absolute value of the current element in the array
			int absoluteValue = Math.abs(a[i]);
			// If the element at absolute value index is positive then make it negative
			if (a[absoluteValue - 1] > 0) {
				a[absoluteValue - 1] = -a[absoluteValue - 1];
			} else {
				// If the element encountered is negative it means that this element is
				// the repeating element
				System.out.println("Repeating element: " + absoluteValue);
			}
		}

		// Loop again through the modified array
		for (int i = 0; i < a.length; i++) {
			// If the element is positive then it means this index is not present in the
			// original array hence it is the missing element
			if (a[i] > 0) {
				System.out.println("Missing element: " + (i + 1));
			}
		}
	}
}
