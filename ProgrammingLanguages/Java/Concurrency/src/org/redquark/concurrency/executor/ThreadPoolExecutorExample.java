package org.redquark.concurrency.executor;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Anirudh Sharma
 *
 */
public class ThreadPoolExecutorExample {

	public static void main(String[] args) {

		// Creating a task
		Runnable task = () -> {
			try {
				Long duration = (long) (Math.random() * 10);
				System.out.println("Executing: " + Thread.currentThread().getName());
				TimeUnit.SECONDS.sleep(duration);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};

		// Creating instance of ThreadPoolExecutor
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
		for (int i = 0; i < 5; i++) {
			executor.execute(task);
		}

		executor.shutdown();
	}

}
