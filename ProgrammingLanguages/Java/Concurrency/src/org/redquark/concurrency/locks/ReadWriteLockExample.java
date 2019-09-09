package org.redquark.concurrency.locks;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author Anirudh Sharma
 *
 */
public class ReadWriteLockExample {

	// This map will be used to store data that will be manipulated by Reader and
	// Writer threads
	private final static Map<String, String> data = new TreeMap<>();

	// ReentrantReadWriteLock is created
	private final static ReadWriteLock lock = new ReentrantReadWriteLock();

	public static void main(String[] args) {

		// Putting some values in the map
		data.put("1", "One");
		data.put("2", "Two");
		data.put("3", "Three");

		// Starting two reader threads and one writer thread
		Thread readerOne = new Thread(new Reader(), "Reader One");
		Thread readerTwo = new Thread(new Reader(), "Reader Two");
		Thread writer = new Thread(new Writer(), "Writer");

		readerOne.start();
		writer.start();
		readerTwo.start();

		// Wait for all threads to finish then only call the display method
		try {
			readerOne.join();
			writer.join();
			readerTwo.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		display();
	}

	/**
	 * This method is used to read values from the map. This method can be used by
	 * multiple threads simultaneously.
	 */
	public static String get(String key) {

		System.out.println("Inside get() method - Waiting to acquire lock");

		// Acquiring read lock
		lock.readLock().lock();

		System.out.println("Inside get() method - Read lock is acquired");

		try {
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return data.get(key);
		} finally {

			// Releasing read lock
			lock.readLock().unlock();

			System.out.println("Inside get() method - Read lock is released");
		}
	}

	/**
	 * This method is used to store a key, value pair in the map. It acquires write
	 * lock so only one thread can access it at a time.
	 */
	public static String put(String key, String value) {

		System.out.println("Inside put() method - Waiting to acquire lock");

		// Acquiring write lock
		lock.writeLock().lock();

		System.out.println("Inside put() method - Write lock is acquired");

		try {
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return data.put(key, value);
		} finally {

			// Releasing write lock
			lock.writeLock().unlock();
			System.out.println("Inside put() method - Write lock is released");
		}
	}

	public static void display() {
		data.entrySet().forEach(System.out::println);
	}

	private static class Reader implements Runnable {

		@Override
		public void run() {
			System.out.println("Value read by " + Thread.currentThread().getName() + " is: " + get("1"));
		}
	}

	private static class Writer implements Runnable {

		@Override
		public void run() {
			// Putting value in the data map
			put("4", "four");
		}
	}
}
