package org.redquark.collections.hashmap;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Anirudh Sharma
 *
 */
public class ConcurrentHashMapExample {

	public static void main(String[] args) {

		Map<Integer, String> chm = new ConcurrentHashMap<>();

		// Put requires no synchronization
		chm.put(1, "A");
		chm.put(2, "B");

		// Get requires no synchronization
		String value = chm.get(2);
		System.out.println(value);

		Iterator<Integer> iterator = chm.keySet().iterator();

		// Using synchronized block is advisable
		synchronized (chm) {
			while (iterator.hasNext()) {
				Integer key = iterator.next();
				System.out.println(chm.get(key));
			}
		}
	}

}
