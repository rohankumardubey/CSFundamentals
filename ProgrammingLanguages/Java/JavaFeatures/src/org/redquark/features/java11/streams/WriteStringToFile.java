package org.redquark.features.java11.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author Anirudh Sharma
 *
 */
public class WriteStringToFile {

	public static void main(String[] args) {

		Path filePath = Paths.get("resources\\testFile.txt");

		try {

			// Write contents to the file
			Files.writeString(filePath, "\nline6", StandardOpenOption.APPEND);

			// Verify file content
			String content = Files.readString(filePath);

			System.out.println(content);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
