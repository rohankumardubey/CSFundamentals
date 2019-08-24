package org.redquark.collections.queue;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * A thread will wait until there is an element present in the queue.
 * 
 * In given example, a thread is waiting on queue in infinite loop using take()
 * method. It wait for 1 seconds before checking again. As soon as we add
 * elements to queue, it poll the item an
 * 
 * @author Anirudh Sharma
 *
 */
public class PriorityBlockingQueueRetrieval {

	public static void main(String[] args) {

		// Creating the PriorityBlockingQueue
		PriorityBlockingQueue<Integer> queue = new PriorityBlockingQueue<>();

		new Thread(() -> {
			System.out.println("Waiting to poll...");

			try {
				while (true) {
					Integer item = queue.take();
					System.out.println("Polled: " + item);
					Thread.sleep(TimeUnit.SECONDS.toMillis(1));
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();

		try {
			Thread.sleep(TimeUnit.SECONDS.toMillis(2));
			queue.add(1);

			Thread.sleep(TimeUnit.SECONDS.toMillis(2));
			queue.add(2);

			Thread.sleep(TimeUnit.SECONDS.toMillis(2));
			queue.add(3);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
