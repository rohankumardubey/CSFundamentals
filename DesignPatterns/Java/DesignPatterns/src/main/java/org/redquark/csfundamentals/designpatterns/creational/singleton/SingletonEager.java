package org.redquark.csfundamentals.designpatterns.creational.singleton;

/**
 * @Author Anirudh Sharma
 */
public class SingletonEager {

	// Eager initialization of the class
	private static SingletonEager instance = new SingletonEager();

	private SingletonEager() {

	}

	/**
	 * @return @{@link SingletonEager}
	 */
	public static SingletonEager getInstance() {
		return instance;
	}
}
