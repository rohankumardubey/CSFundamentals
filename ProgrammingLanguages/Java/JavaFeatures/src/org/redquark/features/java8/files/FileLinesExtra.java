package org.redquark.features.java8.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Anirudh Sharma
 *
 */
public class FileLinesExtra {

	public static void main(String[] args) {

		String filePath = "resources\\testFile.txt";
		List<String> list = new LinkedList<>();

		try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
			// 1. Filter line 3
			// 2. Convert all to upper case
			// 3. Convert it to a list
			list = stream.filter(line -> !line.startsWith("line3")).map(String::toUpperCase)
					.collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}

		list.forEach(System.out::println);
	}

}
