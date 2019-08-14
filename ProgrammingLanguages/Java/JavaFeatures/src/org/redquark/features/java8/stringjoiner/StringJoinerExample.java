package org.redquark.features.java8.stringjoiner;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/**
 * @author Anirudh Sharma
 *
 */
public class StringJoinerExample {

	public static void main(String[] args) {

		// Join string by a delimiter
		StringJoiner sj = new StringJoiner(", ");
		sj.add("aaa");
		sj.add("bbb");
		sj.add("ccc");
		System.out.println("Join string by a delimiter: " + sj.toString());

		// String with delimiter, prefix and suffix
		StringJoiner sj1 = new StringJoiner("/", "prefix-", "-suffix");
		sj1.add("2019");
		sj1.add("08");
		sj1.add("15");
		System.out.println("Join string by a delimiter, prefix and suffix: " + sj1.toString());

		// Join a list by the delimiter
		List<String> languages = Arrays.asList("Java", "Python", "Node", "C++", "Ruby");
		System.out.println("Joining languages by String.join: " + String.join(", ", languages));
		System.out.println("Joining languages by Collectors.joining: "
				+ languages.stream().map(item -> item).collect(Collectors.joining("|")));

	}

}
