package org.redquark.features.java11.strings;

/**
 * @author Anirudh Sharma
 *
 */
public class IsBlank {

	public static void main(String[] args) {
		
		String emptyString = " ";
		
		System.out.println("Is blank?: " + emptyString.isBlank());
		System.out.println("Is empty?: " + emptyString.isEmpty());
	}

}
