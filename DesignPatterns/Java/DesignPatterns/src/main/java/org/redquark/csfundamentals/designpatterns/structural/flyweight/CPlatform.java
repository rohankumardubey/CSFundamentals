package org.redquark.csfundamentals.designpatterns.structural.flyweight;

/**
 * C implementation of a platform
 *
 * @Author Anirudh Sharma
 */
public class CPlatform implements Platform {

	public CPlatform() {
		System.out.println("C platform object got created!");
	}

	/**
	 * Execution of C language specific code
	 *
	 * @param code - Language specific code object
	 */
	@Override
	public void execute(Code code) {
		System.out.println("Compiling and executing C code");
	}
}
