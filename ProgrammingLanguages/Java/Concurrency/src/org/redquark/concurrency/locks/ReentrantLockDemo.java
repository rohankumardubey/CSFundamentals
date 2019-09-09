package org.redquark.concurrency.locks;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Anirudh Sharma
 *
 */
public class ReentrantLockDemo {

	public static void main(String[] args) {

		ReentrantLock lock = new ReentrantLock();

		Display display = new Display(lock);

		Thread threadOne = new Thread(display, "Thread One");
		Thread threadTwo = new Thread(display, "Thread Two");

		threadOne.start();
		threadTwo.start();
	}

	private static class Display implements Runnable {

		private ReentrantLock reentrantLock;

		public Display(ReentrantLock reentrantLock) {
			this.reentrantLock = reentrantLock;
		}

		@Override
		public void run() {

			System.out.println("Thread: " + Thread.currentThread().getName() + " is waiting to acquire lock.");

			// Acquire lock
			reentrantLock.lock();

			try {
				System.out.println("Thread: " + Thread.currentThread().getName() + " has gotten lock");
				System.out.println("Lock count: " + reentrantLock.getHoldCount());
				someMethod();
			} finally {
				reentrantLock.unlock();
			}

			System.out.println("Lock count after releasing all locks by " + Thread.currentThread().getName() + " is: "
					+ reentrantLock.getHoldCount());
		}

		private void someMethod() {

			System.out.println("In method someMethod(), thread: " + Thread.currentThread().getName()
					+ " is waiting to acquire lock.");

			// Acquiring lock
			reentrantLock.lock();

			try {
				System.out.println("Thread: " + Thread.currentThread().getName() + " has gotten lock");
				System.out.println("Lock count: " + reentrantLock.getHoldCount());
			} finally {
				reentrantLock.unlock();
			}
		}

	}
}
