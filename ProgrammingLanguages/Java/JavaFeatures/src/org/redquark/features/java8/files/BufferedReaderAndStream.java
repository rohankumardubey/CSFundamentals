package org.redquark.features.java8.files;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Anirudh Sharma
 *
 */
public class BufferedReaderAndStream {

	public static void main(String[] args) {

		String filePath = "resources\\testFile.txt";
		List<String> list = new LinkedList<>();

		try (BufferedReader br = Files.newBufferedReader(Paths.get(filePath))) {
			// BufferedReader returns as stream and convert it into a list
			list = br.lines().collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}

		list.forEach(System.out::println);
	}

}
