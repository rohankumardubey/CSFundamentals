package org.redquark.csfundamentals.designpatterns.creational.singleton;

/**
 * @Author Anirudh Sharma
 */
public class SingletonLazy {

	private static SingletonLazy instance = null;

	private SingletonLazy() {

	}

	public static SingletonLazy getInstance() {
		if (instance == null) {
			instance = new SingletonLazy();
		}
		return instance;
	}
}
