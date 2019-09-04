package org.redquark.concurrency.countdownlatch;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * This singleton class is the main startup class
 * 
 * @author Anirudh Sharma
 *
 */
public class ApplicationStartupUtil {

	// List of service checkers
	private static List<BaseHealthChecker> services;

	// This latch will be used to wait on
	private static CountDownLatch latch;

	// Singleton instance
	private static final ApplicationStartupUtil INSTANCE = new ApplicationStartupUtil();

	private ApplicationStartupUtil() {

	}

	public static ApplicationStartupUtil getInstance() {
		return INSTANCE;
	}

	public static boolean checkExtenalServices() throws InterruptedException {

		// Initialize the latch with the number of service checkers
		latch = new CountDownLatch(3);

		// Add checkers in the list
		services = new LinkedList<>();
		services.add(new NetwokHealthChecker(latch));
		services.add(new CacheHealthChecker(latch));
		services.add(new DatabaseHealthChecker(latch));

		// Start service checkers using Executor framework
		ExecutorService executor = Executors.newFixedThreadPool(services.size());

		for (final BaseHealthChecker healthChecker : services) {
			executor.execute(healthChecker);
		}

		// Now wait until all the services are checked
		latch.await();

		// Services are filed and now proceed with the startup
		for (final BaseHealthChecker healthChecker : services) {
			if (!healthChecker.isServiceUp()) {
				return false;
			}
		}
		return true;
	}
}
