package org.redquark.concurrency.basic;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author Anirudh Sharma
 *
 */
public class ProducerConsumerUsingBlockingQueue {

	public static void main(String[] args) {

		BlockingQueue<Integer> sharedQueue = new LinkedBlockingQueue<>();

		Thread producer = new Thread(new Producer(sharedQueue));
		Thread consumer = new Thread(new Consumer(sharedQueue));

		producer.start();
		consumer.start();

	}

	private static class Producer implements Runnable {

		private BlockingQueue<Integer> sharedQueue;

		public Producer(BlockingQueue<Integer> sharedQueue) {
			this.sharedQueue = sharedQueue;
		}

		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				try {
					System.out.println("Produced: " + i);
					sharedQueue.put(i);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}

	private static class Consumer implements Runnable {

		private BlockingQueue<Integer> sharedQueue;

		public Consumer(BlockingQueue<Integer> sharedQueue) {
			this.sharedQueue = sharedQueue;
		}

		@Override
		public void run() {
			while (true) {
				try {
					System.out.println("Consumed: " + sharedQueue.take());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
