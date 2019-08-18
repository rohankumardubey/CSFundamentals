package org.redquark.features.java11.strings;

/**
 * @author Anirudh Sharma
 *
 */
public class Strip {

	public static void main(String[] args) {

		String str = "  Hello World !!   ";
		
		System.out.println(str.strip()); // "Hello World !!"
		System.out.println(str.stripLeading()); // "Hello World !! "
		System.out.println(str.stripTrailing()); // " Hello World !!"

		// Using Regex
		System.out.println(str.replaceAll("^[ \t]+|[ \t]+$", "")); // "Hello World !!"
		System.out.println(str.replaceAll("^[ \t]+", "")); // "Hello World !! "
		System.out.println(str.replaceAll("[ \t]+$", "")); // " Hello World !!"
	}

}
