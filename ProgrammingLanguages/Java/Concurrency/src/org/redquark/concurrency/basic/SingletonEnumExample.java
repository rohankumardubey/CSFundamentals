package org.redquark.concurrency.basic;

/**
 * @author Anirudh Sharma
 *
 */
public class SingletonEnumExample {

	public static void main(String[] args) {

		Singleton instance = Singleton.INSTANCE;

		System.out.println("Before setting value: " + instance.getValue());
		instance.setValue(3);
		System.out.println("After setting value: " + instance.getValue());
	}

	public enum Singleton {
		INSTANCE;

		int value;

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}
	}
}
