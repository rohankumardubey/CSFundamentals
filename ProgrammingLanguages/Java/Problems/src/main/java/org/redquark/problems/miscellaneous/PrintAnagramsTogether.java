package org.redquark.problems.miscellaneous;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of words, print all anagrams together. For example, if the
 * given array is {“cat”, “dog”, “tac”, “god”, “act”}, then output may be “cat
 * tac act dog god”.
 * 
 * @author Anirudh Sharma
 *
 */
public class PrintAnagramsTogether {

	public static void main(String[] args) {

		String arr[] = { "cat", "dog", "tac", "god", "act" };
		printAnagrams(arr);
	}

	private static void printAnagrams(String[] a) {

		// This map will store the words corresponding to their anagrams
		Map<String, List<String>> wordAnagrams = new HashMap<>();

		// Loop over all the words present in the Array
		for (int i = 0; i < a.length; i++) {

			// Sort each element of the Array
			String word = a[i];
			char[] letters = word.toCharArray();
			Arrays.sort(letters);
			String sortedWord = new String(letters);

			// Calculate hashcode of String after sorting
			if (wordAnagrams.containsKey(sortedWord)) {
				wordAnagrams.get(sortedWord).add(word);
			} else {
				// This is the first time we are adding a word for the calculated hashcode
				List<String> words = new ArrayList<>();
				words.add(word);
				wordAnagrams.put(sortedWord, words);
			}
		}

		// Print all values where size > 1
		for (String s : wordAnagrams.keySet()) {
			List<String> values = wordAnagrams.get(s);
			if (values.size() > 1) {
				System.out.println(values);
			}
		}
	}
}
