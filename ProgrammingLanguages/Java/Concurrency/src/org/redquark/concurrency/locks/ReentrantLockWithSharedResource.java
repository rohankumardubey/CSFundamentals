package org.redquark.concurrency.locks;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Anirudh Sharma
 *
 */
public class ReentrantLockWithSharedResource {

	public static void main(String[] args) {

		ReentrantLock lock = new ReentrantLock();

		Counter counter = new Counter(lock);

		Thread threadOne = new Thread(counter, "Thread One");
		Thread threadTwo = new Thread(counter, "Thread Two");

		threadOne.start();
		threadTwo.start();
	}

	private static class Shared {
		private static int count = 0;
	}

	private static class Counter implements Runnable {

		private ReentrantLock reentrantLock;

		public Counter(ReentrantLock reentrantLock) {
			this.reentrantLock = reentrantLock;
		}

		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName() + " is waiting to acquire lock");

			// Acquiring lock
			reentrantLock.lock();

			try {

				System.out.println(Thread.currentThread().getName() + " has gotten lock");
				Shared.count++;
				System.out.println("Shared counter variable's value: " + Shared.count);
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				System.out.println(Thread.currentThread().getName() + " is releasing lock");
				reentrantLock.unlock();
			}
		}
	}
}
