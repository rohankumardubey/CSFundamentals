package org.redquark.collections.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * In this class we will illustrate thread safety of the ConcurrentHashMap
 * 
 * We’ll first try to insert 400 elements in a HashMap (which is not thread
 * safe) using 4 threads with each thread inserting 100 elements. Expected size
 * of the HashMap is 400 after the execution.
 * 
 * Then we will perform the same operation with the ConcurrentHashMap.
 * 
 * @author Anirudh Sharma
 *
 */
public class ConcurrentHashMapIllustration {

	private static Map<String, String> testMap;

	public static void main(String[] args) {

		// Creating an instance of HashMap
		testMap = new HashMap<>();
		System.out.println("Size of HashMap: " + threadStuff(testMap).size());

		// Changing the implementation to ConcurrentHashMap
		testMap = new ConcurrentHashMap<>();
		System.out.println("Size of ConcurrentHashMap: " + threadStuff(testMap).size());
	}

	private static Map<String, String> threadStuff(Map<String, String> testMap) {
		// Creating some threads
		Thread t1 = new Thread(new ThreadMap(testMap));
		Thread t2 = new Thread(new ThreadMap(testMap));
		Thread t3 = new Thread(new ThreadMap(testMap));
		Thread t4 = new Thread(new ThreadMap(testMap));

		// Starting all threads
		t1.start();
		t2.start();
		t3.start();
		t4.start();

		try {
			t1.join();
			t2.join();
			t3.join();
			t4.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return testMap;
	}

	private static class ThreadMap implements Runnable {

		private Map<String, String> testMap;

		public ThreadMap(Map<String, String> map) {
			this.testMap = map;
		}

		@Override
		public void run() {
			String threadName = Thread.currentThread().getName();
			for (int i = 0; i < 100; i++) {
				// Adding thread name to make element unique
				testMap.put(threadName + i, threadName + i);
				try {
					// Delay to verify thread interference
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
