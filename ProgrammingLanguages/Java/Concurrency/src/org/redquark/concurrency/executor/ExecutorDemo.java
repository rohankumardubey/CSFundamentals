package org.redquark.concurrency.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * We have two tasks running. Neither is expected to terminate, and both should
 * run for the duration of the application’s life. 
 * 
 * 1. If any task throws an exception, the application will catch it and restart
 * the task. 
 * 2. If any task runs to completion, the application will notice and
 * restart the task.
 * 
 * @author Anirudh Sharma
 *
 */
public class ExecutorDemo {

	private static ExecutorService executor = null;
	private static volatile Future<?> taskOneResult = null;
	private static volatile Future<?> taskTwoResult = null;

	public static void main(String[] args) {
		executor = Executors.newFixedThreadPool(2);
		while (true) {
			try {
				if (taskOneResult == null || taskOneResult.isDone() || taskOneResult.isCancelled()) {
					taskOneResult = executor.submit(new TaskOne());
				}
				if (taskTwoResult == null || taskTwoResult.isDone() || taskTwoResult.isCancelled()) {
					taskTwoResult = executor.submit(new TaskTwo());
				}
				Thread.sleep(5000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private static class TaskOne implements Runnable {
		@Override
		public void run() {
			while (true) {
				System.out.println("Executing task one");
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private static class TaskTwo implements Runnable {
		@Override
		public void run() {
			while (true) {
				System.out.println("Executing task two");
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
