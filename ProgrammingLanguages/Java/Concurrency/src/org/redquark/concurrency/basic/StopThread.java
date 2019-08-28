package org.redquark.concurrency.basic;

import java.util.UUID;

/**
 * @author Anirudh Sharma
 *
 */
public class StopThread {

	public static void main(String[] args) {

		ThreadStopExample threadStopExample = new ThreadStopExample();
		Thread thread = new Thread(threadStopExample);
		thread.start();

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		threadStopExample.doStop();
	}

	private static class ThreadStopExample implements Runnable {

		private boolean doStop = false;

		public synchronized void doStop() {
			this.doStop = true;
		}

		private synchronized boolean keepRunning() {
			return this.doStop == false;
		}

		@Override
		public void run() {
			while (keepRunning()) {
				// Keep doing what this thread does
				// Creating some random strings
				System.out.println("Generated String: " + UUID.randomUUID());
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
