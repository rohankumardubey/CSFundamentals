package org.redquark.csfundamentals.designpatterns.structural.flyweight;

/**
 * Python implementation of a platform
 *
 * @Author Anirudh Sharma
 */
public class PythonPlatform implements Platform {


	public PythonPlatform() {
		System.out.println("Python platform object got created!");
	}

	/**
	 * Execution of the code in the Python language
	 *
	 * @param code - Language specific code object
	 */
	@Override
	public void execute(Code code) {
		System.out.println("Compiling and executing python code");
	}
}
