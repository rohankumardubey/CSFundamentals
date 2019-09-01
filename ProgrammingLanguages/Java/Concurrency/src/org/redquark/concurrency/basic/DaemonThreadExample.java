package org.redquark.concurrency.basic;

import java.util.Scanner;

/**
 * @author Anirudh Sharma
 *
 */
public class DaemonThreadExample {

	public static void main(String[] args) {

		System.out.println("Enter *true* for daemon thread and *false* for non-daemon thread");
		Scanner scanner = new Scanner(System.in);
		boolean flag = scanner.nextBoolean();
		scanner.close();

		Thread worker = new Thread(new Worker());
		worker.setDaemon(flag);
		worker.start();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Main thread ends");
	}

	private static class Worker implements Runnable {

		@Override
		public void run() {
			int count = 0;
			while (true) {
				System.out.println("Count: " + count++);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
