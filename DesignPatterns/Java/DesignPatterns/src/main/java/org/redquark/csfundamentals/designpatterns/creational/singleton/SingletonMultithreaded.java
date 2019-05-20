package org.redquark.csfundamentals.designpatterns.creational.singleton;

/**
 * @Author Anirudh Sharma
 */
public class SingletonMultithreaded {

	private static SingletonMultithreaded instance;

	private SingletonMultithreaded() {

	}

	public static synchronized SingletonMultithreaded getInstance() {
		if (instance == null) {
			instance = new SingletonMultithreaded();
		}
		return instance;
	}
}
