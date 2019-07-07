package org.redquark.features.java8.streams;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * This class shows how to filter null values from the stream
 * 
 * @author Anirudh Sharma
 */
public class FilterANullValue {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// See https://www.baeldung.com/java-stream-operated-upon-or-closed-exception
		// for below usage
		Supplier<Stream<String>> language = () -> Stream.of("Java", "Ruby", "Python", null, "PHP", "C", null, "C++");

		// Converting stream to list
		List<String> languageList = language.get().collect(Collectors.toList());

		// Printing the original list
		System.out.println("|----------< Original list >----------|");
		languageList.forEach(System.out::println);

		// Filter the null values from the stream
		List<String> filteredLanguageList = language.get().filter(item -> item != null).collect(Collectors.toList());

		// Printing the filtered list
		System.out.println("|----------< Filtered list >----------|");
		filteredLanguageList.forEach(System.out::println);
	}

}
