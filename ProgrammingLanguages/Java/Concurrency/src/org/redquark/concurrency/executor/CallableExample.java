package org.redquark.concurrency.executor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * This class demonstrates the use of Executor framework with a task created by
 * using Callable interface
 * 
 * @author Anirudh Sharma
 *
 */
public class CallableExample {

	public static void main(String[] args) {

		ExecutorService taskExecutor = Executors.newFixedThreadPool(2);

		for (int i = 0; i <= 5; i++) {
			Task task = new Task("Task-" + i);
			Future<String> result = taskExecutor.submit(task);

			try {
				System.out.println("Result of Task-" + i + " is: " + result.get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
		taskExecutor.shutdown();
	}

	private static class Task implements Callable<String> {

		private String name;

		public Task(String name) {
			this.name = name;
		}

		@Override
		public String call() throws Exception {
			Long duration = (long) (Math.random() * 10);
			String message = "Executing " + name;
			TimeUnit.SECONDS.sleep(duration);
			return message;
		}

	}
}
