package org.redquark.features.java8.arrays;

/**
 * @author Anirudh Sharma
 *
 */
public class ConvertToStreamCharArray {

	public static void main(String[] args) {

		String password = "password123";

		password.chars().mapToObj(x -> (char) x).forEach(System.out::println);
	}

}
