package org.redquark.java.fundamentals.introduction;

import java.util.Arrays;

/**
 * @Author Anirudh Sharma
 * <p>
 * This class demonstrates the use of loops in java
 */
public class Introduction04 {

	/*
	 * There are normally four types of loops in Java
	 *
	 * 1. For loop
	 * 2. For Each loop
	 * 3. For loop with label
	 * 4. While loop
	 * 5. Do While loop
	 */

	public static void main(String[] args) {

		/*
		 * variable initialization” happens only once when for loop begins execution.
		 *
		 * “termination condition” should result in boolean expression, if it returns false then for loop terminates.
		 *
		 * “increment/decrement” operation is performed after each for loop execution. In most of the scenarios, it should
		 * lead towards the termination condition unless you want for loop to not terminate at all.
		 */

		for (int i = 1; i <= 10; i++) {
			System.out.println("Current value: " + i);
		}

		/*
		 * Java for each loop is also called enhanced for loop. We can use for each loop to iterate over array or
		 * collection elements.
		 *
		 * Java for each loop is the recommended way wherever it’s possible to use it. It’s very easy and compact to write.
		 */

		int[] arr = {2, 5, 7, 9, 1, 6, 8, 4, 3, 10};
		for (Integer i : arr) {
			System.out.println(i);
		}

		/*
		 * We can add a label to for loop, it’s useful with break and continue statements to get out of outer loop.
		 *
		 * Note that by default break and continue statements work with inner loop only.
		 *
		 * Here is an example of for loop with label and how it’s used with continue statement.
		 */

		int[][] integerArray = {{1, -2, 3}, {0, 3}, {1, 2, 5}, {9, 2, 5}};

		process:
		for (int i = 0; i < integerArray.length; i++) {
			boolean allPositive = true;
			for (int j = 0; j < integerArray[i].length; j++) {
				if (integerArray[i][j] < 0) {
					allPositive = false;
					continue process;
				}
			}
			if (allPositive) {
				System.out.println("Processing: " + Arrays.toString(integerArray[i]));
			}
			allPositive = true;
		}

		/*
		 * While loop requires only one boolean expression to work.
		 */

		int i = 1;

		while (i <= 10) {
			System.out.println("Current value: " + i);
			i++;
		}

		/*
		 * Java do while loop is used to execute a block of statements continuously until the given condition is true.
		 * do while loop in Java is similar to while loop except that the condition is checked after the statements are
		 * executed, so do while loop guarantees the loop execution at least once.
		 */

		int j = 1;
		do {
			System.out.println("Current value: " + j);
			j++;
		} while (j < 1);
	}

}
