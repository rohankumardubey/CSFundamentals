package org.redquark.concurrency.basic;

/**
 * @author Anirudh Sharma
 *
 */
public class SingletonWithEnum {
	
	public enum Singleton {
		INSTANCE;
		
		int value;
		
		public int getValue() {
			return this.value;
		}
		
		public void setValue(int value) {
			this.value = value;
		}
	}

	public static void main(String[] args) {

		Singleton singleton = Singleton.INSTANCE;
		for(int i = 0; i < 3; i++) {
			System.out.println("Hashcode of singleton: " + singleton.hashCode());
			singleton.setValue(i);
			System.out.println("Value: " + singleton.getValue() + "\n");
		}
	}

}
