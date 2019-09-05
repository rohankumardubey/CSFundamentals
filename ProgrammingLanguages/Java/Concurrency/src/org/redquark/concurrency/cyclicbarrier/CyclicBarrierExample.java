package org.redquark.concurrency.cyclicbarrier;

import java.time.LocalDateTime;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author Anirudh Sharma
 *
 */
public class CyclicBarrierExample {

	public static void main(String[] args) {

		final CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

		Thread serviceOne = new Thread(new ServiceOne(cyclicBarrier));
		Thread serviceTwo = new Thread(new ServiceTwo(cyclicBarrier));

		System.out.println("Starting both the services at: " + LocalDateTime.now());

		serviceOne.start();
		serviceTwo.start();
		
		try {
			cyclicBarrier.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
		
		System.out.println("Ending both the services at: " + LocalDateTime.now());
	}

	private static class ServiceOne implements Runnable {

		private final CyclicBarrier cyclicBarrier;

		public ServiceOne(CyclicBarrier cyclicBarrier) {
			this.cyclicBarrier = cyclicBarrier;
		}

		@Override
		public void run() {

			System.out.println("Starting service one...");
			try {
				Thread.sleep(2000);
				System.out.println("Service One has its finished work. Waiting for others...");
				cyclicBarrier.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				e.printStackTrace();
			}
			System.out.println("Wait is over. Let's complete Service One");
		}
	}

	private static class ServiceTwo implements Runnable {

		private final CyclicBarrier cyclicBarrier;

		public ServiceTwo(CyclicBarrier cyclicBarrier) {
			this.cyclicBarrier = cyclicBarrier;
		}

		@Override
		public void run() {

			System.out.println("Starting service two...");

			try {
				Thread.sleep(3000);
				System.out.println("Service Two has finished its work. Waiting for others...");
				cyclicBarrier.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				e.printStackTrace();
			}
			System.out.println("Wait is over. Let's complete Service Two");
		}

	}
}
