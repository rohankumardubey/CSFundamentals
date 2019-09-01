package org.redquark.concurrency.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Anirudh Sharma
 *
 */
public class RunnableExample {

	public static void main(String[] args) {
		
		ExecutorService taskExecutor = Executors.newFixedThreadPool(2);

		for (int i = 0; i <= 5; i++) {
			Task task = new Task("Task-" + i);
			taskExecutor.submit(task);
		}
		taskExecutor.shutdown();

	}

	private static class Task implements Runnable {

		private String name;

		public Task(String name) {
			this.name = name;
		}

		@Override
		public void run() {
			try {
				Long duration = (long) (Math.random() * 10);
				String message = "Executing " + name;
				TimeUnit.SECONDS.sleep(duration);
				System.out.println(message);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}
