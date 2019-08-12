package org.redquark.features.java8.optional;

import java.util.Optional;

/**
 * @author Anirudh Sharma
 *
 */
public class OptionalIsAndIfPresent {

	public static void main(String[] args) {
		
		Optional<String> gender = Optional.of("MALE");
		Optional<String> emptyGender = Optional.empty();
		
		String value = gender.isPresent() ? "Value available" : "Value not available";
		System.out.println(value);
		
		gender.ifPresent(g -> System.out.println("In gender optional, value available"));
		
		emptyGender.ifPresent(g -> System.out.println("In emptyGenerator optional, value not present"));
	}

}
