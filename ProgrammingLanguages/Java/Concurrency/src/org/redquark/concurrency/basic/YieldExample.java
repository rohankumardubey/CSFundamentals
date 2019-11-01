package org.redquark.concurrency.basic;

/**
 * @author Anirudh Sharma
 *
 */
public class YieldExample {

	public static void main(String[] args) {

		Thread A = new Thread(new A());
		Thread B = new Thread(new B());

		A.setPriority(Thread.MIN_PRIORITY);
		B.setPriority(Thread.MAX_PRIORITY);

		A.start();
		B.start();

	}

	/**
	 * First thread with low priority
	 */
	private static class A implements Runnable {
		@Override
		public void run() {
			for (int i = 1; i <= 5; i++) {
				System.out.println("Thread A: " + i);
				Thread.yield();
			}
		}
	}

	/**
	 * Second thread with high priority
	 */
	private static class B implements Runnable {
		@Override
		public void run() {
			for (int i = 1; i <= 5; i++) {
				System.out.println("Thread B: " + i);
				Thread.yield();
			}
		}
	}
}
