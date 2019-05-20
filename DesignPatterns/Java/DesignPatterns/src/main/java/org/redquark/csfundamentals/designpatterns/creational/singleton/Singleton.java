package org.redquark.csfundamentals.designpatterns.creational.singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * @Author Anirudh Sharma
 */
public class Singleton implements Serializable {

	private static final long serialVersionUID = 1L;

	private static Singleton instance = new Singleton();

	private Singleton() {
		if (instance != null) {
			throw new IllegalStateException("Already created");
		}
	}

	public static Singleton getInstance() {
		return instance;
	}

	private static Class getClass(String className) throws ClassNotFoundException {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		if (classLoader == null) {
			classLoader = Singleton.class.getClassLoader();
		}
		return classLoader.loadClass(className);
	}

	private Object readResolve() throws ObjectStreamException {
		return instance;
	}

	private Object writeReplace() throws ObjectStreamException {
		return instance;
	}

	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException("Singleton class - cannot be cloned");
	}
}

