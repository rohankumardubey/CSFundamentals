package org.redquark.features.java11.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @author Anirudh Sharma
 *
 */
public class GetStreamOfLines {

	public static void main(String[] args) {

		try {

			// Read contents from a file
			//
			// This method returns a stream of lines extracted from a given multi-line
			// string, separated by line terminators.
			Stream<String> lines = Files.lines(Paths.get("resources\\testFile.txt"));

			lines.forEach(System.out::println);

			lines.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
