package org.redquark.concurrency.basic;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Anirudh Sharma
 *
 */
public class ProducerConsumer {

	public static void main(String[] args) {

		Queue<Integer> taskQueue = new LinkedList<>();
		int MAX_CAPACITY = 5;

		Thread producer = new Thread(new Producer(taskQueue, MAX_CAPACITY), "PRODUCER");
		Thread consumer = new Thread(new Consumer(taskQueue), "CONSUMER");

		producer.start();
		consumer.start();
	}

	private static class Producer implements Runnable {

		private final Queue<Integer> taskQueue;
		private final int MAX_CAPACITY;

		public Producer(Queue<Integer> queue, int capacity) {
			this.taskQueue = queue;
			this.MAX_CAPACITY = capacity;
		}

		@Override
		public void run() {
			int counter = 0;
			while (true) {
				try {
					synchronized (taskQueue) {
						while (taskQueue.size() == MAX_CAPACITY) {
							System.out.println("Queue is full, " + Thread.currentThread().getName()
									+ " is waiting, size: " + taskQueue.size());
							taskQueue.wait();
						}
						Thread.sleep(1000);
						taskQueue.add(++counter);
						System.out.println("Produced: " + counter);
						taskQueue.notifyAll();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private static class Consumer implements Runnable {

		private final Queue<Integer> taskQueue;

		public Consumer(Queue<Integer> queue) {
			this.taskQueue = queue;
		}

		@Override
		public void run() {
			while (true) {
				try {
					synchronized (taskQueue) {
						while (taskQueue.isEmpty()) {
							System.out.println("Queue is empty, " + Thread.currentThread().getName()
									+ " is waiting, size: " + taskQueue.size());
							taskQueue.wait();
						}
						Thread.sleep(1000);
						System.out.println("Consumed: " + taskQueue.poll());
						taskQueue.notifyAll();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
