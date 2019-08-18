package org.redquark.features.java10.lvti;

import java.util.Arrays;

/**
 * @author Anirudh Sharma
 *
 */
public class LVTIExamples {

	public static void main(String[] args) {

		var name = "Anirudh Sharma";
		System.out.println("Name: " + name);

		var age = 29;
		System.out.println("Age: " + age);

		var isMarried = false;
		System.out.println("Is married: " + isMarried);

		var technologies = Arrays.asList("Java", "Python", "JavaScript", "HTML", "CSS");
		System.out.print("Technologies: ");
		for (var tech : technologies) {
			System.out.print(tech + " ");
		}

	}
}
