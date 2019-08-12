package org.redquark.features.java8.optional;

import java.util.Optional;

/**
 * @author Anirudh Sharma
 *
 */
public class OptionalAndFilter {

	public static void main(String[] args) {

		Optional<String> gender = Optional.of("MALE");
		Optional<String> emptyGender = Optional.empty();

		System.out.println(gender.filter(g -> g.equals("male")));
		System.out.println(gender.filter(g -> g.equalsIgnoreCase("male")));
		System.out.println(emptyGender.filter(g -> g.equalsIgnoreCase("MALE")));
	}

}
