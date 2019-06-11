package org.redquark.csfundamentals.designpatterns.structural.flyweight;

/**
 * C Plus Plus implementation of the platform
 *
 * @Author Anirudh Sharma
 */
public class CPPPlatform implements Platform {

	public CPPPlatform() {
		System.out.println("C Plus Plus platform object got created!");
	}

	/**
	 * Execution of C Plus Plus code
	 *
	 * @param code - Language specific code object
	 */
	@Override
	public void execute(Code code) {
		System.out.println("Compiling and executing C++ code!");
	}
}
