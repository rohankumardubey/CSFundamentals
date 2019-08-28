package org.redquark.concurrency.threadlocal;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Anirudh Sharma
 *
 */
public class ThreadLocalDemo {

	public static void main(String[] args) {

		Thread threadOne = new Thread(new DemoTask());
		Thread threadTwo = new Thread(new DemoTask());
		Thread threadThree = new Thread(new DemoTask());

		threadOne.start();
		threadTwo.start();
		threadThree.start();
	}

	private static class DemoTask implements Runnable {

		// Atomic integer containing the next thread ID to be assigned
		private static final AtomicInteger nextId = new AtomicInteger(5);

		private static final ThreadLocal<Integer> threadId = new ThreadLocal<>() {
			@Override
			protected Integer initialValue() {
				return nextId.getAndIncrement();
			}
		};

		// Returns the current thread's unique ID, assigning it if necessary
		public int getThreadId() {
			return threadId.get();
		}

		// Return the current thread's starting timestamp
		private static final ThreadLocal<Date> startDate = new ThreadLocal<>() {
			@Override
			protected Date initialValue() {
				return new Date();
			}
		};

		@Override
		public void run() {
			System.out.printf("Starting Thread: %s : %s\n", getThreadId(), startDate.get());
			try {
				TimeUnit.SECONDS.sleep((int) Math.rint(Math.random() * 10));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.printf("Thread Finished: %s : %s\n", getThreadId(), startDate.get());
		}

	}
}
