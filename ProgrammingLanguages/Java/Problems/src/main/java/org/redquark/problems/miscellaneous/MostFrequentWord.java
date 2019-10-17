package org.redquark.problems.miscellaneous;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of words find the most occurring word in it
 * 
 * @author Anirudh Sharma
 *
 */
public class MostFrequentWord {

	public static void main(String[] args) {

		String a[] = { "geeks", "for", "geeks", "a", "portal", "to", "learn", "can", "be", "computer", "science",
				"zoom", "yup", "fire", "in", "be", "data", "geeks" };

		System.out.println("Most frequent word: " + findMostFrequentWord(a));
	}

	/**
	 * This method returns the most frequent word in an array of Strings
	 */
	private static String findMostFrequentWord(String[] a) {

		// HashMap to store word and its frequency
		Map<String, Integer> countMap = new HashMap<>();

		// Iterate through array of words
		for (int i = 0; i < a.length; i++) {
			if (countMap.containsKey(a[i])) {
				int count = countMap.get(a[i]);
				countMap.put(a[i], count + 1);
			} else {
				countMap.put(a[i], 1);
			}
		}

		String key = "";
		int value = 0;

		for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
			// Check for word having highest frequency
			if (entry.getValue() > value) {
				value = entry.getValue();
				key = entry.getKey();
			}
		}

		return key;
	}
}
