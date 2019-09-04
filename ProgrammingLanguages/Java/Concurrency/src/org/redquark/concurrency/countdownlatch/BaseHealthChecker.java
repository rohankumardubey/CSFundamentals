package org.redquark.concurrency.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * This class is a Runnable and parent for all specific external service health
 * checkers. This remove the code duplicacy and central control over latch.
 * 
 * @author Anirudh Sharma
 *
 */
public abstract class BaseHealthChecker implements Runnable {

	private CountDownLatch latch;
	private String serviceName;
	private boolean isServiceUp;

	/**
	 * Get latch object in constructor so that after completing the task, thread can
	 * countdown the latch
	 */
	public BaseHealthChecker(CountDownLatch latch, String serviceName) {
		this.latch = latch;
		this.serviceName = serviceName;
		this.isServiceUp = false;
	}

	@Override
	public void run() {

		try {
			verifyService();
			isServiceUp = true;
		} catch (Throwable t) {
			t.printStackTrace(System.err);
			isServiceUp = false;
		} finally {
			if (latch != null) {
				latch.countDown();
			}
		}
	}

	/**
	 * @return the serviceName
	 */
	public String getServiceName() {
		return serviceName;
	}

	/**
	 * @return the isServiceUp
	 */
	public boolean isServiceUp() {
		return isServiceUp;
	}

	public abstract void verifyService();
}
