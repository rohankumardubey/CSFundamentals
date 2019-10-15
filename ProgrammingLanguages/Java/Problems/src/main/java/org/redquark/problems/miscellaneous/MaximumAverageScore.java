package org.redquark.problems.miscellaneous;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a file containing data of student name and marks scored by him/her in 3
 * subjects. The task is to find the list of students having the maximum average
 * score. Note : If more than one student has the maximum average score, print
 * them as per the order in the file.
 * 
 * @author Anirudh Sharma
 *
 */
public class MaximumAverageScore {

	public static void main(String[] args) {

		String[] file = { "Ramesh", "90", "70", "40", "Adam", "50", "10", "40", "Suresh", "22", "1", "56", "Rocky",
				"100", "90", "10" };
		getStudentWithMaxAverage(file);
	}

	/**
	 * This method gets the student with maximum average
	 */
	private static void getStudentWithMaxAverage(String[] s) {

		// List that will store the names of students with maximum average
		List<String> result = new LinkedList<>();

		// Maximum average initialization
		int maxAverage = Integer.MIN_VALUE;

		// Current average
		int average;

		// Check for all the elements in the array
		for (int i = 0; i < s.length; i = i + 4) {

			// Average of the current student
			average = (Integer.parseInt(s[i + 1]) + Integer.parseInt(s[i + 2]) + Integer.parseInt(s[i + 3])) / 3;

			// Check if the current average is greater than the maximum average
			if (maxAverage < average) {
				// If yes, then update the value of maxAverage
				maxAverage = average;
				// Clear the list in case it has some previously added elements for the lesser
				// maxAverage
				result.clear();
				// Add the current student to the list
				result.add(s[i]);
			}

			// Checks if the current average is equal to the maximum average
			else if (maxAverage == average) {
				// If yes, then add the student with the maximum average in the list
				result.add(s[i]);
			}
		}

		// Iterate for each element in the list and print it
		for (String student : result) {
			System.out.print(student + " ");
		}

		// Print the maximum average
		System.out.print(maxAverage);
	}
}
