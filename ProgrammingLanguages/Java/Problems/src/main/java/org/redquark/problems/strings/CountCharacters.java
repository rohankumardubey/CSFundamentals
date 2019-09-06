package org.redquark.problems.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Anirudh Sharma
 *
 */
public class CountCharacters {

	public static void main(String[] args) {

		// Get input string from the user
		Scanner scanner = new Scanner(System.in);
		String word = scanner.nextLine().toLowerCase();

		Map<Character, Integer> characterCount = new HashMap<>();

		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			
			// We don't need to count spaces
			if(c == ' ') {
				continue;
			}
			
			// If the current character is already encountered, then increment its count by 1
			if(characterCount.containsKey(c)) {
				characterCount.put(c, characterCount.get(c) + 1);
			} else {
				// If the current character is encountered for the first time, set its count to 1
				characterCount.put(c, 1);
			}
		}
		
		System.out.println(characterCount);
		
		// Closing to avoid memory leakage - IMPORTANT
		scanner.close();
	}
}
