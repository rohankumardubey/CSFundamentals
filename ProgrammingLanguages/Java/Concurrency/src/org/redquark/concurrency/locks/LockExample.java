package org.redquark.concurrency.locks;

import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Anirudh Sharma
 *
 */
public class LockExample {

	public static void main(String[] args) {

		PrinterQueue printerQueue = new PrinterQueue();
		Thread[] threads = new Thread[10];

		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(new PrintingJob(printerQueue), "Thread-" + i);
		}
		for (int i = 0; i < threads.length; i++) {
			threads[i].start();
		}
	}

	private static class PrinterQueue {

		private final Lock queueLock = new ReentrantLock();

		public void printJob(Object document) {
			queueLock.lock();
			try {
				Long duration = (long) (Math.random() * 10000);
				System.out.println(Thread.currentThread().getName() + ": PrintQueue: Printing a job during "
						+ (duration / 1000) + " seconds :: Time - " + new Date());
				Thread.sleep(duration);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				System.out.printf("%s: The document has been printed\n", Thread.currentThread().getName());
				queueLock.unlock();
			}
		}
	}

	private static class PrintingJob implements Runnable {

		private PrinterQueue printerQueue;

		public PrintingJob(PrinterQueue printerQueue) {
			this.printerQueue = printerQueue;
		}

		@Override
		public void run() {
			System.out.printf("%s: Going to print a document\n", Thread.currentThread().getName());
			printerQueue.printJob(new Object());
		}

	}
}
