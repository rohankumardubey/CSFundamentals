package org.redquark.features.java8.arrays;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author Anirudh Sharma
 *
 */
public class CheckIfValueExists {

	public static void main(String[] args) {

		String[] alphabet = new String[] { "A", "B", "C" };
		boolean result = Arrays.stream(alphabet).anyMatch("A"::equals);

		if (result) {
			System.out.println("Value exists");
		} else {
			System.out.println("Value does not exist");
		}

		int[] number = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		boolean result2 = IntStream.of(number).anyMatch(x -> x == 4);

		if (result2) {
			System.out.println("Integer value exists");
		} else {
			System.out.println("Integer value does not exist");
		}
	}

}
