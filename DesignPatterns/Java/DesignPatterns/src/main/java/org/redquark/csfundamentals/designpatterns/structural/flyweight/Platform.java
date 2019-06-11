package org.redquark.csfundamentals.designpatterns.structural.flyweight;

/**
 * @Author Anirudh Sharma
 */
public interface Platform {

	/**
	 * This method will be used to execute the code
	 *
	 * @param code - Language specific code object
	 */
	void execute(Code code);
}
