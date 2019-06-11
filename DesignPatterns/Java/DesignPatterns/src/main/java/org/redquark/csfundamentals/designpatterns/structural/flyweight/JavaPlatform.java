package org.redquark.csfundamentals.designpatterns.structural.flyweight;

/**
 * Java implementation of platform
 *
 * @Author Anirudh Sharma
 */
public class JavaPlatform implements Platform {

	public JavaPlatform() {
		System.out.println("Java platform object got created!");
	}

	/**
	 * Execution of code in Java language
	 *
	 * @param code - Language specific code object
	 */
	@Override
	public void execute(Code code) {
		System.out.println("Compiling and executing Java code!");
	}
}
