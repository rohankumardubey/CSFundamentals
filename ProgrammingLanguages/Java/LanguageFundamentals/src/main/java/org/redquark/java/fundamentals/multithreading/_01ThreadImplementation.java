package org.redquark.java.fundamentals.multithreading;

/**
 * @Author Anirudh Sharma
 */
public class _01ThreadImplementation {

	public static void main(String[] args) {

		/* This object will be shared by different threads. This is the difference between the objects created by Thread and Runnable.
		 * Each thread is associated with the unique object in case it is created by extending the thread class.
		 * While threads using the Runnable objects share the same.
		 *
		 * Below we are creating the Runnable object which will be shared with all the threads created in the for loop.
		 * While we are creating new object of Thread each time and they have one to one mapping.
		 */
		RunnableDemo runnableDemo = new RunnableDemo();

		for (int i = 0; i < 3; i++) {
			// Below threads are created by extending the Thread class
			ThreadDemo threadDemo = new ThreadDemo();
			// Starting the thread
			threadDemo.start();

			// Below threads are created by implementing the Runnable interface
			Thread t = new Thread(runnableDemo);
			// Starting the thread
			t.start();
		}
	}

	static class ThreadDemo extends Thread {
		@Override
		public void run() {
			System.out.println("Thread created by extending the Thread class: " + Thread.currentThread().getName() +
					" is running");
		}
	}

	static class RunnableDemo implements Runnable {

		@Override
		public void run() {
			System.out.println("Thread created by implementting the Runnable interface: " + Thread.currentThread().getName() +
					" is running");
		}
	}
}
