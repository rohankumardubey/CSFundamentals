package org.redquark.collections.queue;

import java.util.Random;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;

/**
 * @author Anirudh Sharma
 *
 */
public class LinkedTransferQueueExample {

	public static void main(String[] args) {

		// Creating a TransferQueue
		TransferQueue<Integer> transferQueue = new LinkedTransferQueue<>();

		// Producer thread
		new Thread(() -> {
			Random random = new Random(1);
			try {
				while (true) {
					System.out.println("Producer is waiting to transfer message...");
					Integer message = random.nextInt();
					boolean added = transferQueue.tryTransfer(message);
					if (added) {
						System.out.println("Producer added the message: " + message);
					}
					Thread.sleep(TimeUnit.SECONDS.toMillis(3));
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();

		// Consumer thread
		new Thread(() -> {
			try {
				while (true) {
					System.out.println("Consumer is waiting to take message...");
					Integer message = transferQueue.take();
					System.out.println("Consumer recieved the message: " + message);
					Thread.sleep(TimeUnit.SECONDS.toMillis(3));
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
	}

}
