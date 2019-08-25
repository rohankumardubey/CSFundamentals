package org.redquark.collections.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author Anirudh Sharma
 *
 */
public class ArrayBlockingQueueExample {

	public static void main(String[] args) {

		// Creating an ArrayBlockingQueue
		BlockingQueue<Integer> abq = new ArrayBlockingQueue<>(5);

		// Producer thread
		new Thread(() -> {
			int i = 0;
			try {
				while (true) {
					abq.put(++i);
					System.out.println("Added: " + i);
					Thread.sleep(TimeUnit.SECONDS.toMillis(1));
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();

		// Consumer thread
		new Thread(() -> {
			try {
				while (true) {
					Integer item = abq.take();
					System.out.println("Polled: " + item);
					Thread.sleep(TimeUnit.SECONDS.toMillis(2));
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
	}

}
