package org.redquark.concurrency.basic;

/**
 * @author Anirudh Sharma
 *
 */
public class VolatileExample implements Runnable {

	// Without the volatile, hotspot lifts the access outside the loop
	// (while (str == null)) and run() never terminates.
	private volatile String str;

	private void setStr(String str) {
		this.str = str;
	}

	@Override
	public void run() {

		// In case the thread never has the chance to execute the setStr method the
		// value of str will be null resulting in infinite loop
		while (str == null) {
			// Empty while
		}
		System.out.println(str);
	}

	public static void main(String[] args) throws InterruptedException {

		VolatileExample volatileExample = new VolatileExample();

		// Spawning a new thread from the current one
		new Thread(volatileExample).start();

		// Making the current thread sleep for one second so that the another thread can
		// have the chance to execute and change the value of str
		Thread.sleep(1000);

		// Setting the string variable on the current thread and change the value of
		// str
		volatileExample.setStr("Testing volatality");

	}
}
