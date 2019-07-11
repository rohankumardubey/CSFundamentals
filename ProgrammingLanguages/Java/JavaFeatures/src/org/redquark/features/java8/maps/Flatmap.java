package org.redquark.features.java8.maps;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author Anirudh Sharma
 *
 */
public class Flatmap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String[][] data = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};
		
		arrayPlusFlatMap(data);
	}

	private static void arrayPlusFlatMap(String[][] data) {
		
		// Stream<String[]>
		Stream<String[]> temp = Arrays.stream(data);
		
		// Stream<String>, Good!
		Stream<String> stringStream = temp.flatMap(item -> Arrays.stream(item));
		
		// Filtering
		Stream<String> stream = stringStream.filter(item -> "b".equals(item));
		
		stream.forEach(System.out::println);
	}
}
