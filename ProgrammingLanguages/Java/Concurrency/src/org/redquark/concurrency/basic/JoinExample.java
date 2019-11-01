package org.redquark.concurrency.basic;

/**
 * @author Anirudh Sharma
 *
 */
public class JoinExample {

	public static void main(String[] args) {

		Runnable A = () -> {
			System.out.println("First task started");
			try {
				System.out.println("Sleeping for 2 seconds");
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("First task completed");
		};

		Runnable B = () -> {
			System.out.println("Second task completed");
		};

		Thread a = new Thread(A);
		Thread b = new Thread(B);

		try {
			a.start();
			a.join();
			b.start();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
