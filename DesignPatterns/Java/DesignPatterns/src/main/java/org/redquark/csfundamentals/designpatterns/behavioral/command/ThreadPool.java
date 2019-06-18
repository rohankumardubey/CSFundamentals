package org.redquark.csfundamentals.designpatterns.behavioral.command;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * This class creates a pool of threads and allow a thread to fetch and execute the job from the job queue
 *
 * @Author Anirudh Sharma
 */
public class ThreadPool {

	private final BlockingQueue<Job> jobQueue;
	private final Thread[] jobThreads;
	private volatile boolean shutdown;

	public ThreadPool(int n) {
		this.jobQueue = new LinkedBlockingQueue<>();
		this.jobThreads = new Thread[n];

		for (int i = 0; i < n; i++) {
			jobThreads[i] = new Worker("Pool thread: " + i);
			jobThreads[i].start();
		}
	}

	public void addJob(Job r) {

		try {
			jobQueue.put(r);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

	public void shutdownPool() {
		while (!jobQueue.isEmpty()) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		shutdown = true;
		for (Thread workerThread : jobThreads) {
			workerThread.interrupt();
		}
	}

	private class Worker extends Thread {

		public Worker(String name) {
			super(name);
		}

		public void run() {
			while (!shutdown) {
				try {
					Job r = jobQueue.take();
					r.run();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
