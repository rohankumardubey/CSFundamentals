package org.redquark.features.java8.optional;

import java.util.Optional;

/**
 * @author Anirudh Sharma
 *
 */
public class OptionalMapAndFlatMap {

	public static void main(String[] args) {

		Optional<String> nonEmptyGender = Optional.of("male");
		Optional<String> emptyGender = Optional.empty();

		System.out.println("Non-empty optional: " + nonEmptyGender.map(String::toUpperCase));
		System.out.println("Empty optional: " + emptyGender.map(String::toUpperCase));

		Optional<Optional<String>> nonEmptyOptionalGender = Optional.of(Optional.of("male"));
		System.out.println("Optional value: " + nonEmptyOptionalGender);
		System.out.println("Optional.map: " + nonEmptyOptionalGender.map(gender -> gender.map(String::toUpperCase)));
		System.out.println(
				"Optional.flatMap: " + nonEmptyOptionalGender.flatMap(gender -> gender.map(String::toUpperCase)));
	}

}
