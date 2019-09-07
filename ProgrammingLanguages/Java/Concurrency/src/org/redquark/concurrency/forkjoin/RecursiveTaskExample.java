package org.redquark.concurrency.forkjoin;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * This example demonstrates Fork/Join framework to find out occurrences of even
 * numbers in a large array.
 * 
 * This class illustrates how to create a task that returns result
 * 
 * @author Anirudh Sharma
 *
 */
public class RecursiveTaskExample {

	private static final int SIZE = 10_000_000;
	private static int[] array = randomArray();

	public static void main(String[] args) {

		// Main task
		EvenCounter mainTask = new EvenCounter(array, 0, SIZE);

		ForkJoinPool pool = new ForkJoinPool();
		Integer evenCount = pool.invoke(mainTask);

		System.out.println("Count of even numbers in array: " + evenCount);

	}

	private static int[] randomArray() {
		int[] randomArr = new int[SIZE];
		Random random = new Random();
		for (int i = 0; i < SIZE; i++) {
			randomArr[i] = random.nextInt(100);
		}
		return randomArr;
	}

	private static class EvenCounter extends RecursiveTask<Integer> {

		private static final long serialVersionUID = -4214549123572753761L;

		// Large array to store elements from which we need to find the occurrences of
		// even numbers
		private int[] array;

		// Start index of the array
		private int start;

		// End index of the array
		private int end;

		// This will determine that on what threshold the task will not subdivide
		// further
		private final int threshold = 100_000;

		public EvenCounter(int[] array, int start, int end) {
			this.array = array;
			this.start = start;
			this.end = end;
		}

		@Override
		protected Integer compute() {
			if (end - start < threshold) {
				// Counter variable
				Integer count = 0;
				// Loop to check for the divisibility by 2
				for (int i = start; i < end; i++) {
					if (array[i] % 2 == 0) {
						count++;
					}
				}
				return count;
			} else {
				// Find the middle element for the recursive task
				int middle = (end + start) / 2;
				// Sub tasks
				EvenCounter taskOne = new EvenCounter(array, start, middle);
				EvenCounter taskTwo = new EvenCounter(array, middle, end);
				// Invoking all subtasks
				invokeAll(taskOne, taskTwo);
				// Return the computed result
				return taskOne.join() + taskTwo.join();
			}
		}
	}
}
