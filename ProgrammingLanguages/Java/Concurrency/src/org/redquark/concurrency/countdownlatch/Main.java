package org.redquark.concurrency.countdownlatch;

/**
 * @author Anirudh Sharma
 *
 */
public class Main {

	public static void main(String[] args) {

		boolean result = false;

		try {
			result = ApplicationStartupUtil.checkExtenalServices();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("External services validation completed !! Result was :: " + result);
	}

}
