package org.redquark.concurrency.executor;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author Anirudh Sharma
 *
 */
public class ExecuteRunnableTasks {

	public static void main(String[] args) {

		// Create a Runnable task
		Runnable task = () -> {
			try {
				TimeUnit.MILLISECONDS.sleep(1000);
				System.out.println("Current Time : " + LocalDateTime.now());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};

		// Create an instance of ExecutorService
		ExecutorService executor = Executors.newFixedThreadPool(10);

		// Execute task using execute method
		executor.execute(task);

		// Execute task using submit method
		Future<String> result = executor.submit(task, "DONE");

		while (!result.isDone()) {

			try {
				System.out.println("The method returns value: " + result.get());
				break;
			} catch (InterruptedException | ExecutionException e) {
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
