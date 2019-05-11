package org.redquark.java.fundamentals.multithreading;

/**
 * @Author Anirudh Sharma
 */
public class _02Lifecycle {

	public static void main(String[] args) throws InterruptedException {

		ThreadA threadA = new ThreadA();
		ThreadB threadB = new ThreadB();

		// Creating the thread
		Thread tA = new Thread(threadA);
		Thread tB = new Thread(threadB);

		// Getting the state of the thread - should be NEW
		System.out.println(tA.getState());

		// Starting the thread
		tA.start();
		tB.start();

		// Getting the state of the threads - should be RUNNABLE
		System.out.println(tA.getState());

		// Creating a new Thread that will also use ThreadB's runnable object
		Thread tC = new Thread(threadB);
		tC.start();

		Thread.sleep(1000);
		System.out.println(tB.getState());

		ThreadC.init();

		Thread tE = new Thread(new ThreadE());
		tE.start();

		Thread.sleep(1000);
		System.out.println(tE.getState());

		Thread tF = new Thread(new ThreadF());
		tF.start();

		Thread.sleep(1000);
		System.out.println(tF.getState());
	}

	private static class ThreadA implements Runnable {

		@Override
		public void run() {
			System.out.println("RUNNING");
		}
	}

	private static class ThreadB implements Runnable {

		@Override
		public void run() {
			commonResource();
		}

		private void commonResource() {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
	}

	private static class ThreadC implements Runnable {

		static Thread tC;

		static void init() {
			tC = new Thread(new ThreadC());
			tC.start();
		}

		@Override
		public void run() {
			Thread tD = new Thread(new ThreadD());
			tD.start();
			try {
				tD.join();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				e.printStackTrace();
			}
		}
	}

	private static class ThreadD implements Runnable {

		@Override
		public void run() {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				e.printStackTrace();
			}
			System.out.println(ThreadC.tC.getState());
		}
	}

	private static class ThreadE implements Runnable {

		@Override
		public void run() {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				e.printStackTrace();
			}
		}
	}

	private static class ThreadF implements Runnable {

		@Override
		public void run() {
			// No processing in this block
		}
	}
}
