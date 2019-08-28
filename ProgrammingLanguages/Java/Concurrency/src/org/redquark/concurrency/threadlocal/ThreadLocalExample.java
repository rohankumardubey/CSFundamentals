package org.redquark.concurrency.threadlocal;

/**
 * @author Anirudh Sharma
 *
 */
public class ThreadLocalExample {

	public static void main(String[] args) throws InterruptedException {

		TestRunnable testRunnable = new TestRunnable();

		Thread threadOne = new Thread(testRunnable);
		Thread threadTwo = new Thread(testRunnable);

		threadOne.start();
		threadTwo.start();

		threadOne.join();
		threadTwo.join();
	}

	private static class TestRunnable implements Runnable {

		private ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

		@Override
		public void run() {
			threadLocal.set((int) (Math.random() * 100d));
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(threadLocal.get());
		}

	}
}
