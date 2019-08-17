package org.redquark.features.java9.streams;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Anirudh Sharma
 *
 */
public class TakeWhileAndDropWhile {

	public static void main(String[] args) {

		List<String> alphabets = List.of("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p",
				"q", "r", "s", "t", "u", "v", "w", "x", "y", "z");

		List<String> subsetOne = alphabets.stream().takeWhile(item -> !item.equals("f")).collect(Collectors.toList());
		System.out.println("Subset one: " + subsetOne);

		List<String> subsetTwo = alphabets.stream().dropWhile(item -> !item.equals("n")).collect(Collectors.toList());
		System.out.println("Subset Two" + subsetTwo);
	}

}
