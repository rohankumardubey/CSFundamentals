package org.redquark.concurrency.basic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author Anirudh Sharma
 *
 */
public class SingletonExample {

	public static void main(String[] args) {

		// Create two instances of Singleton class - Normally
		Singleton instanceOne = Singleton.getInstance();
		Singleton instanceTwo = Singleton.getInstance();

		System.out.println("Instance 1: " + instanceOne.hashCode());
		System.out.println("Instance 2: " + instanceTwo.hashCode());

		// Create two instance of Singleton class in a Multithreaded environment
		new Thread(() -> {
			Singleton instanceThree = Singleton.getInstance();
			System.out.println("Instance 3: " + instanceThree.hashCode());
		}).start();

		new Thread(() -> {
			Singleton instanceFour = Singleton.getInstance();
			System.out.println("Instance 4: " + instanceFour.hashCode());
		}).start();

		// Create two instances of Singleton class to demonstrate Serialization and
		// Deserialization
		Singleton instanceFive = Singleton.getInstance();
		ObjectOutput out = null;

		// Serialization
		try {
			out = new ObjectOutputStream(new FileOutputStream("file.ser"));
			out.writeObject(instanceFive);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		ObjectInput in = null;
		Singleton instanceSix = null;

		// Deserialization
		try {
			in = new ObjectInputStream(new FileInputStream("file.ser"));
			instanceSix = (Singleton) in.readObject();
			in.close();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}

		System.out.println("Instance 5: " + instanceFive.hashCode());
		System.out.println("Instance 6: " + instanceSix.hashCode());

		// Create to instances of Singleton to show reflection proof behavior
		Singleton instanceSeven = Singleton.getInstance();
		Singleton instanceEight = null;
		try {
			Class<Singleton> clazz = Singleton.class;
			Constructor<Singleton> constructor = clazz.getDeclaredConstructor();
			constructor.setAccessible(true);
			instanceEight = constructor.newInstance();
		} catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException
				| InstantiationException e) {
			e.printStackTrace();
		}

		System.out.println("Instance 7: " + instanceSeven.hashCode());
		System.out.println("Instance 6: " + instanceEight.hashCode());
	}

	private static class Singleton implements Serializable {

		private static final long serialVersionUID = -9217889024802407096L;

		// Volatile variable is used for "happens-before" guarantee in a multithreaded
		// environment
		private static volatile Singleton instance;

		/**
		 * Private constructor - so that no other class can create instance of this
		 * class
		 */
		private Singleton() {

			// This is done to prevent creation of an instance via Reflection API
			if (instance != null) {
				throw new RuntimeException("Use the getInstance() method to get the single instance of this class");
			}
		}

		/**
		 * This static method is used by external classes to get the instance of this
		 * Singleton. This will implement the double checked locking for lazy
		 * initialization
		 */
		public static Singleton getInstance() {
			if (instance == null) {
				synchronized (Singleton.class) {
					if (instance == null) {
						instance = new Singleton();
					}
				}
			}
			return instance;
		}

		/**
		 * This method makes singleton from Serialization and Deserialization operation
		 */
		protected Object readResolve() {
			return getInstance();
		}
	}
}
