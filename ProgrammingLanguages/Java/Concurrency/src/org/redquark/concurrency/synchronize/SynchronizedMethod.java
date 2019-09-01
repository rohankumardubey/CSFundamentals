package org.redquark.concurrency.synchronize;

/**
 * @author Anirudh Sharma
 *
 */
public class SynchronizedMethod {

	public static void main(String[] args) {

		final Math math = new Math();

		Runnable r = () -> {
			math.printNumbers(3);
		};

		Thread threadOne = new Thread(r, "ONE");
		Thread threadTwo = new Thread(r, "TWO");

		threadOne.start();
		threadTwo.start();
	}

	private static class Math {

		public synchronized void printNumbers(int n) {
			for (int i = 0; i < n; i++) {
				try {
					System.out.println(Thread.currentThread().getName() + " :: " + i);
					Thread.sleep(500);
					System.out.println("Does thread hold lock? =>" +  Thread.holdsLock(this));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
