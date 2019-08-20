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

		/*
		 * Using synchronized block is advisable.
		 * 
		 * iterator obtained from ConcurrentHashMap does not throw
		 * ConcurrentModificationException. However, iterators are designed to be used
		 * by only one thread at a time. It means each iterator we obtain from a
		 * ConcurrentHashMap is designed to be used by a single thread and should not be
		 * passed around.
		 * 
		 * If we do so then there is no guarantee that one thread will see the changes
		 * to the map that the other thread performs (without obtaining a new iterator
		 * from the map). The iterator is guaranteed to reflect the state of the map at
		 * the time of it’s creation.
		 */
		synchronized (chm) {
			while (iterator.hasNext()) {
				Integer key = iterator.next();
				System.out.println(chm.get(key));
			}
		}
	}

}
