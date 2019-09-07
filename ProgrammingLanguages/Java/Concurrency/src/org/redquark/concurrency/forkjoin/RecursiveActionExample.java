package org.redquark.concurrency.forkjoin;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * @author Anirudh Sharma
 *
 */
public class RecursiveActionExample {

	private static final int SIZE = 10_000_000;
	private static int[] array = randomArray();

	public static void main(String[] args) {

		// The number which should be multiplied
		int number = 9;

		System.out.println("First 10 elements of the array before:");
		print();

		ArrayTransform mainTask = new ArrayTransform(array, number, 0, SIZE);
		ForkJoinPool pool = new ForkJoinPool();
		pool.invoke(mainTask);

		System.out.println("\nFirst 10 elements of the array after:");
		print();
	}

	private static void print() {
		for (int i = 0; i < 10; i++) {
			System.out.print(array[i] + " ");
		}
	}

	/**
	 * This method just creates a random array
	 */
	private static int[] randomArray() {
		int[] randomArr = new int[SIZE];
		Random random = new Random();
		for (int i = 0; i < SIZE; i++) {
			randomArr[i] = random.nextInt(100);
		}
		return randomArr;
	}

	/**
	 * A RecursiveAction class does not return a result. The task can be sub-divided
	 * into subtasks of itself by divide and conquer approach.
	 * 
	 * Suppose that we need to do a transformation on a very large array of numbers.
	 * For the sake of simplicity, the transformation is simply multiply every
	 * element in the array by a specified number.
	 *
	 */
	private static class ArrayTransform extends RecursiveAction {

		private static final long serialVersionUID = -546107511388452275L;

		// This array will store integers which will be multiplied by the passed integer
		private int[] array;

		// The number which will be multiplied with each element of the array
		private int number;

		// Start index of the array
		private int start;

		// End index of the array
		private int end;

		// This will determine that on what threshold the task will not subdivide
		// further
		private final int threshold = 100_000;

		public ArrayTransform(int[] array, int number, int start, int end) {
			this.array = array;
			this.number = number;
			this.start = start;
			this.end = end;
		}

		@Override
		protected void compute() {

			// Check if the number of elements on which computation needs to be done are
			// less than the threshold
			if (end - start < threshold) {
				// Compute directly - no further subdivision
				for (int i = start; i < end; i++) {
					array[i] = array[i] * number;
				}
			} else {
				// Find the middle element
				int middle = (start + end) / 2;
				// Create subtasks
				ArrayTransform taskOne = new ArrayTransform(array, number, start, middle);
				ArrayTransform taskTwo = new ArrayTransform(array, number, middle, end);
				// Invoking both tasks simultaneously
				invokeAll(taskOne, taskTwo);
			}
		}

	}
}
