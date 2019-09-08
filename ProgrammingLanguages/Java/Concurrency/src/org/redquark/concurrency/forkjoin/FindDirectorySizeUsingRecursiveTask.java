package org.redquark.concurrency.forkjoin;

import java.io.File;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * @author Anirudh Sharma
 *
 */
public class FindDirectorySizeUsingRecursiveTask {

	public static void main(String[] args) {

		long startTime = Instant.now().toEpochMilli();
		final double size = DirectorySize.sizeOf(new File("E:\\development")) / (1024.0 * 1024.0);
		long endTime = Instant.now().toEpochMilli();

		System.out.println("Calculated size:" + size + " MB in " + (endTime - startTime) / 1000.0 + " seconds");

	}

	private static class DirectorySize extends RecursiveTask<Long> {

		private static final long serialVersionUID = 2565616512375373295L;

		private final File file;

		public DirectorySize(File file) {
			this.file = Objects.requireNonNull(file);
		}

		@Override
		protected Long compute() {

			System.out.println("Compute size of: " + file);

			if (file.isFile()) {
				return file.length();
			}

			final List<DirectorySize> tasks = new ArrayList<>();

			final File[] children = file.listFiles();

			if (children != null) {
				for (final File child : children) {
					final DirectorySize task = new DirectorySize(child);
					task.fork();
					tasks.add(task);
				}
			}

			long size = 0;
			for (final DirectorySize task : tasks) {
				size = size + task.join();
			}

			return size;
		}

		public static long sizeOf(final File file) {
			final ForkJoinPool pool = new ForkJoinPool();
			try {
				return pool.invoke(new DirectorySize(file));
			} finally {
				pool.shutdown();
			}
		}
	}
}
