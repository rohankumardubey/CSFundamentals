package org.redquark.features.java8.random;

import java.util.Random;

/**
 * @author Anirudh Sharma
 *
 */
public class RandomInts {

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println(getRandomNumberInRange(32, 43));
		}
	}

	private static int getRandomNumberInRange(int min, int max) {
		Random r = new Random();
		return r.ints(min, (max + 1)).limit(1).findFirst().getAsInt();
	}

}
