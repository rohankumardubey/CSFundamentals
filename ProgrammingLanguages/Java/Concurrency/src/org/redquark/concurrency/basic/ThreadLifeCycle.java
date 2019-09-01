package org.redquark.concurrency.basic;

/**
 * @author Anirudh Sharma
 *
 */
public class ThreadLifeCycle {

	public static Thread threadOne;

	public static void main(String[] args) {

		threadOne = new Thread(new ThreadOne());

		// Thread 1 is created and currently in the new state
		System.out.println("State of thread 1 after creating it: " + threadOne.getState());
		threadOne.start();

		// Thread 1 moved to Runnable state
		System.out.println("State of thread 1 after calling start(): " + threadOne.getState());
	}

	private static class ThreadOne implements Runnable {

		@Override
		public void run() {

			// Creating the instance of ThreadTwo runnable and put it in a Thread object
			Thread threadTwo = new Thread(new ThreadTwo());

			// Thread 2 is created and should be in the new state
			System.out.println("State of thread 2 after creating it: " + threadTwo.getState());

			// Starting the thread
			threadTwo.start();

			// Thread 2 has now moved to the Runnable state
			System.out.println("State of thread 2 after calling start(): " + threadTwo.getState());

			// Moving thread 1 to the timed_waiting state
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println("State of thread 2 after calling sleep(): " + threadTwo.getState());

			try {
				// Waiting for thread 2 to die
				threadTwo.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println("State of thread 2 after its execution is finished: " + threadTwo.getState());
		}

	}

	private static class ThreadTwo implements Runnable {

		@Override
		public void run() {

			try {
				// Moving thread 2 to timed_waiting state
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println("State of thread 1 while it called join on thread 2: " + threadOne.getState());

			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}
