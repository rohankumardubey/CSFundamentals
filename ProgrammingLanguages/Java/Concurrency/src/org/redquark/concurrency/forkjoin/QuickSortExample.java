package org.redquark.concurrency.forkjoin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * @author Anirudh Sharma
 *
 */
public class QuickSortExample {

	public static void main(String[] args) {

		final int SIZE = 10000;
		List<Double> data = new ArrayList<>(SIZE);

		for (int i = 0; i < SIZE; i++) {
			data.add(Math.random() * 100);
		}

		QuickSort<Double> quickSort = new QuickSort<>(data);

		ForkJoinPool pool = new ForkJoinPool();
		pool.invoke(quickSort);
		
		data.stream().forEach(System.out::println);
	}

	private static class QuickSort<T extends Comparable<T>> extends RecursiveAction {

		private static final long serialVersionUID = 6035351930658973135L;
		
		private List<T> data;
		private int left;
		private int right;

		public QuickSort(List<T> data) {
			this.data = data;
			this.left = 0;
			this.right = data.size() - 1;
		}

		public QuickSort(List<T> data, int left, int right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}

		@Override
		protected void compute() {
			if (left < right) {
				int pivot = left + (right - left) / 2;
				pivot = partition(pivot);
				invokeAll(new QuickSort<>(data, left, pivot - 1), new QuickSort<>(data, pivot + 1, right));
			}
		}

		private int partition(int pivot) {
			T pivotValue = data.get(pivot);
			swap(pivot, right);

			int storeIndex = left;
			for (int i = left; i < right; i++) {
				if (data.get(i).compareTo(pivotValue) < 0) {
					swap(i, storeIndex);
					storeIndex++;
				}
			}

			swap(storeIndex, right);

			return storeIndex;
		}

		private void swap(int i, int j) {
			if (i != j) {
				T temp = data.get(i);
				data.set(i, data.get(j));
				data.set(j, temp);
			}
		}
	}
}
