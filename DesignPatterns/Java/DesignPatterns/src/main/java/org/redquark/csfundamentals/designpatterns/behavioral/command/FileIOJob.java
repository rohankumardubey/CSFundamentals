package org.redquark.csfundamentals.designpatterns.behavioral.command;

/**
 * Command class for FileIO
 *
 * @Author Anirudh Sharma
 */
public class FileIOJob implements Job {

	private FileIO fileIO;

	public void setFileIO(FileIO fileIO) {
		this.fileIO = fileIO;
	}

	@Override
	public void run() {
		System.out.println("Job Id: " + Thread.currentThread().getId() + " executing File IO jobs");
		if (fileIO != null) {
			fileIO.execute();
		}

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}
