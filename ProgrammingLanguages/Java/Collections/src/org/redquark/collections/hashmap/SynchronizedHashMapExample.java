package org.redquark.collections.hashmap;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author Anirudh Sharma
 *
 */
public class SynchronizedHashMapExample {

	public static void main(String[] args) {

		Map<Integer, String> syncMap = Collections.synchronizedMap(new HashMap<>());

		// Put requires no synchronization - as all methods are synchronized
		syncMap.put(1, "A");
		syncMap.put(2, "B");

		// Get requires no synchronization
		String value = syncMap.get(1);
		System.out.println("Value: " + value);

		Iterator<Integer> iterator = syncMap.keySet().iterator();

		/*
		 * Using synchronized block is advisable
		 * 
		 * Fail-fast iterator
		 */
		synchronized (syncMap) {
			while (iterator.hasNext()) {
				Integer key = iterator.next();
				System.out.println("Value corresponding to key: " + key + " is: " + syncMap.get(key));
			}
		}
	}

}
