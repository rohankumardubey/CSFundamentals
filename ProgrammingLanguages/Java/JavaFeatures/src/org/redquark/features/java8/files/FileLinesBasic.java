package org.redquark.features.java8.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @author Anirudh Sharma
 *
 */
public class FileLinesBasic {

	public static void main(String[] args) {

		String filePath = "resources\\testFile.txt";

		// Read file into stream, try-with-resources
		try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
			stream.forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
