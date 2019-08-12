package org.redquark.features.java8.optional;

import java.util.Optional;

/**
 * @author Anirudh Sharma
 *
 */
public class Basic {

	public static void main(String[] args) {

		Optional<String> gender = Optional.of("MALE");
		String answer1 = "Yes";
		String answer2 = null;

		System.out.println("Non-empty optional: " + gender);
		System.out.println("Non-empty optional: Gender value: " + gender.get());
		System.out.println("Empty optional: " + Optional.empty());

		System.out.println("OfNullable on Non-empty optional: " + Optional.ofNullable(answer1));
		System.out.println("ofNullable on Empty optional: " + Optional.ofNullable(answer2));
	}
}
