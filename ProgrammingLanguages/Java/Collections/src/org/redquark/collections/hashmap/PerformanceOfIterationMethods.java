package org.redquark.collections.hashmap;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author Anirudh Sharma
 *
 */
public class PerformanceOfIterationMethods {

	public static void main(String[] args) {

		Map<String, Integer> performanceMap = new HashMap<>();

		// Adding one million entries in a HashMap
		for (int i = 0; i < 1_000_000; i++) {
			performanceMap.put("key_" + i, i);
		}

		long startTime = Calendar.getInstance().getTimeInMillis();

		// Using entry set in for-each loop
		for (Map.Entry<String, Integer> entry : performanceMap.entrySet()) {
			entry.getKey();
			entry.getValue();
		}

		System.out.println("Using entrySet() in for each : " + (Calendar.getInstance().getTimeInMillis() - startTime));

		startTime = Calendar.getInstance().getTimeInMillis();

		// Using key set in for each loop
		for (String key : performanceMap.keySet()) {
			performanceMap.get(key);
		}

		System.out.println("Using keySet() in for each: " + (Calendar.getInstance().getTimeInMillis() - startTime));

		startTime = Calendar.getInstance().getTimeInMillis();

		// Using entry set and iterator
		Iterator<Map.Entry<String, Integer>> iterator = performanceMap.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<String, Integer> entry = iterator.next();
			entry.getKey();
			entry.getValue();
		}

		System.out.println("Using entrySet() and iterator: " + (Calendar.getInstance().getTimeInMillis() - startTime));

		startTime = Calendar.getInstance().getTimeInMillis();

		// Using keySet() and iterator
		Iterator<String> itr = performanceMap.keySet().iterator();
		while (itr.hasNext()) {
			String key = itr.next();
			performanceMap.get(key);
		}

		System.out.println("Using keySet() and iterator: " + (Calendar.getInstance().getTimeInMillis() - startTime));
	}

}
