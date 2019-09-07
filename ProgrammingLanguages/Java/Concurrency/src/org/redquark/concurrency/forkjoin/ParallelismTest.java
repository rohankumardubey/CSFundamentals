package org.redquark.concurrency.forkjoin;

import java.time.Instant;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * This class demonstrates how the level of Parallelism affects the computation
 * time.
 * 
 * @author Anirudh Sharma
 *
 */
public class ParallelismTest {

	private static final int SIZE = 10_000_000;
	private static int[] array = randomArray();

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int threshold = scanner.nextInt();
		int parallelism = scanner.nextInt();
		scanner.close();

		long startTime = Instant.now().toEpochMilli();

		ArrayCounter mainTask = new ArrayCounter(array, 0, SIZE, threshold);
		ForkJoinPool pool = new ForkJoinPool(parallelism);
		Integer evenCount = pool.invoke(mainTask);
		System.out.println("Even number count: " + evenCount);
		
		long endTime = Instant.now().toEpochMilli();

		System.out.println("Execution time: " + (endTime - startTime) + " milliseconds");

	}

	private static int[] randomArray() {
		int[] randomArr = new int[SIZE];
		Random random = new Random();
		for (int i = 0; i < SIZE; i++) {
			randomArr[i] = random.nextInt(100);
		}
		return randomArr;
	}

	private static class ArrayCounter extends RecursiveTask<Integer> {

		private static final long serialVersionUID = -6596537517567692031L;
		
		private int[] array;
		private int start;
		private int end;
		private int threshold;

		public ArrayCounter(int[] array, int start, int end, int threshold) {
			this.array = array;
			this.start = start;
			this.end = end;
			this.threshold = threshold;
		}

		@Override
		protected Integer compute() {
			if (end - start < threshold) {
				Integer count = 0;
				for (int i = start; i < end; i++) {
					if (array[i] % 2 == 0) {
						count++;
					}
				}
				return count;
			} else {
				int middle = (start + end) / 2;
				ArrayCounter taskOne = new ArrayCounter(array, start, middle, threshold);
				ArrayCounter taskTwo = new ArrayCounter(array, middle, end, threshold);
				invokeAll(taskOne, taskTwo);
				return taskOne.join() + taskTwo.join();
			}
		}

	}
}
