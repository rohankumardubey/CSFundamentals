package org.redquark.csfundamentals.designpatterns.behavioral.command;

/**
 * @Author Anirudh Sharma
 */
public class CommandMain {

	public static void main(String[] args) {

		ThreadPool threadPool = new ThreadPool(10);

		Email email;
		EmailJob emailJob = new EmailJob();

		SMS sms;
		SMSJob smsJob = new SMSJob();

		FileIO fileIO;
		FileIOJob fileIOJob = new FileIOJob();

		Logging logging;
		LoggingJob loggingJob = new LoggingJob();

		for (int i = 0; i < 5; i++) {

			email = new Email();
			emailJob.setEmail(email);

			sms = new SMS();
			smsJob.setSMS(sms);

			fileIO = new FileIO();
			fileIOJob.setFileIO(fileIO);

			logging = new Logging();
			loggingJob.setLogging(logging);

			threadPool.addJob(emailJob);
			threadPool.addJob(fileIOJob);
			threadPool.addJob(smsJob);
			threadPool.addJob(loggingJob);
		}

		threadPool.shutdownPool();
	}
}
