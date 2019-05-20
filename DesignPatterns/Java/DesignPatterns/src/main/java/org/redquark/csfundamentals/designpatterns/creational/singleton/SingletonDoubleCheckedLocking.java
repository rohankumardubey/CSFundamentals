package org.redquark.csfundamentals.designpatterns.creational.singleton;

/**
 * @Author Anirudh Sharma
 */
public class SingletonDoubleCheckedLocking {

	private volatile static SingletonDoubleCheckedLocking instance = null;

	private SingletonDoubleCheckedLocking() {

	}

	public static SingletonDoubleCheckedLocking getInstance() {
		if (instance == null) {
			synchronized (SingletonDoubleCheckedLocking.class) {
				if (instance == null) {
					instance = new SingletonDoubleCheckedLocking();
				}
			}
		}
		return instance;
	}
}
