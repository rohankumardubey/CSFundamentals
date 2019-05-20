package org.redquark.csfundamentals.designpatterns.creational.singleton;

/**
 * @Author Anirudh Sharma
 */
public class SingletonMain {

	public static void main(String[] args) {

		System.out.println(SingletonEager.getInstance());
		System.out.println(SingletonLazy.getInstance());
		System.out.println(SingletonMultithreaded.getInstance());
		System.out.println(SingletonDoubleCheckedLocking.getInstance());
		System.out.println(Singleton.getInstance());
		System.out.println(SingletonEnum.Instance.SINGLETON_ENUM);
	}
}
