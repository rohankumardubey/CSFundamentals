package org.redquark.concurrency.executor;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author Anirudh Sharma
 *
 */
public class ExecuteCallableTasks {

	public static void main(String[] args) {

		// Callable task
		Callable<String> task = () -> {
			try {
				TimeUnit.MILLISECONDS.sleep(1000);
				return "Current time : " + LocalDateTime.now();
			} catch (InterruptedException e) {
				e.printStackTrace();
				return "";
			}
		};

		// Executor Service instance
		ExecutorService executor = Executors.newFixedThreadPool(1);

		// Same three tasks are added into the list
		List<Callable<String>> tasks = Arrays.asList(task, task, task);

		// Execute all tasks using invokeAll() method
		try {

			List<Future<String>> results = executor.invokeAll(tasks);

			for (Future<String> result : results) {
				System.out.println(result.get());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

		// Execute individual tasks using submit method
		Future<String> result = executor.submit(task);

		while (!result.isDone()) {

			try {

				System.out.println("The method returns value: " + result.get());
				break;
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		executor.shutdown();
	}
}
