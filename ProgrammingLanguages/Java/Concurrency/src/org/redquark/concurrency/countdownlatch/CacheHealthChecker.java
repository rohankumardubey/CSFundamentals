package org.redquark.concurrency.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * @author Anirudh Sharma
 *
 */
public class CacheHealthChecker extends BaseHealthChecker {

	public CacheHealthChecker(CountDownLatch latch) {
		super(latch, "Cache Checker");
	}

	@Override
	public void verifyService() {

		System.out.println("Checking: " + this.getServiceName());
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(this.getServiceName() + " is up!");
	}

}
