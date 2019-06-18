package org.redquark.csfundamentals.designpatterns.behavioral.command;

/**
 * Command class for SMS
 *
 * @Author Anirudh Sharma
 */
public class SMSJob implements Job {

	private SMS sms;

	public void setSMS(SMS sms) {
		this.sms = sms;
	}

	@Override
	public void run() {
		System.out.println("Job Id: " + Thread.currentThread().getId() + " executing SMS jobs");
		if (sms != null) {
			sms.sendSMS();
		}

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}
