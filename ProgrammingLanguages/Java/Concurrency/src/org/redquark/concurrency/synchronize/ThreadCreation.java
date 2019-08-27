package org.redquark.concurrency.synchronize;

/**
 * @author Anirudh Sharma
 *
 */
public class ThreadCreation {

	public static void main(String[] args) {

		ThreadDemo threadDemo = new ThreadDemo();
		threadDemo.start();

		Thread runnableDemo = new Thread(new RunnableDemo());
		runnableDemo.start();
	}

	private static class ThreadDemo extends Thread {

		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName() + " is running by extending the Thread class");
		}
	}

	private static class RunnableDemo implements Runnable {

		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName() + " is running by implementing the Runnable interface");
		}
	}
}
