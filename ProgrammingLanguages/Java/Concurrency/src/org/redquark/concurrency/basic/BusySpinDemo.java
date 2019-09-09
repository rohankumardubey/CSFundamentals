package org.redquark.concurrency.basic;

import java.util.LinkedList;
import java.util.Queue;

/**
 * This thread demonstrates the concept of busy spin in which the consumer
 * thread will wait until the producer thread does not fill the queue up to the
 * size of 5
 * 
 * @author Anirudh Sharma
 *
 */
public class BusySpinDemo {

	public static void main(String[] args) {

		Queue<Integer> sharedQueue = new LinkedList<>();

		Producer producerObj = new Producer(sharedQueue, true);

		Thread producer = new Thread(producerObj, "Producer");
		Thread consumer = new Thread(new Consumer(producerObj), "Consumer");

		producer.start();
		consumer.start();

	}

	private static class Producer implements Runnable {

		private Queue<Integer> sharedQueue;
		private boolean flag;

		public Producer(Queue<Integer> sharedQueue, boolean flag) {
			this.sharedQueue = sharedQueue;
			this.flag = flag;
		}

		@Override
		public void run() {
			System.out.println("Producer thread is running...");
			for (int i = 0; i < 5; i++) {
				System.out.println("Adding to queue - " + Thread.currentThread().getName() + " " + i);
				sharedQueue.add(i);
			}
			flag = false;
		}
	}

	private static class Consumer implements Runnable {

		private Producer producer;

		public Consumer(Producer producer) {
			this.producer = producer;
		}

		@Override
		public void run() {

			// Busy spin loop
			while (this.producer.flag) {
				System.out.println("Waiting for busy spin");
			}

			System.out.println("Consumer starting");
			for (Integer i : producer.sharedQueue) {
				System.out.println("Consuming: " + i);
			}
		}
	}
}
