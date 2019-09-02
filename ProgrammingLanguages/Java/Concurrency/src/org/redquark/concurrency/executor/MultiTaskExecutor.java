package org.redquark.concurrency.executor;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Anirudh Sharma
 *
 */
public class MultiTaskExecutor {

	public static void main(String[] args) {

		BlockingQueue<Runnable> workers = new ArrayBlockingQueue<>(10);

		ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 3, 10, TimeUnit.SECONDS, workers);
		executor.prestartAllCoreThreads();

		List<Runnable> taskGroup = new LinkedList<>();
		taskGroup.add(new TaskOne());
		taskGroup.add(new TaskTwo());
		taskGroup.add(new TaskThree());

		workers.add(new MultiTask(taskGroup));
	}

	private static class TaskOne implements Runnable {

		@Override
		public void run() {
			System.out.println("Executing task one");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private static class TaskTwo implements Runnable {

		@Override
		public void run() {
			System.out.println("Executing task two");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private static class TaskThree implements Runnable {

		@Override
		public void run() {
			System.out.println("Executing task three");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private static class MultiTask implements Runnable {

		private final List<Runnable> runnables;

		public MultiTask(List<Runnable> runnables) {
			this.runnables = runnables;
		}

		@Override
		public void run() {
			for (Runnable runnable : runnables) {
				new Thread(runnable).start();
			}
		}
	}
}
