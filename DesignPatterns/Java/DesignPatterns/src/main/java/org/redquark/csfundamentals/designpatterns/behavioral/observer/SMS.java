package org.redquark.csfundamentals.designpatterns.behavioral.observer;

/**
 * @Author Anirudh Sharma
 */
public class SMS implements Observer {

	private final Subject subject;
	private String description;
	private String userInfo;

	public SMS(Subject subject, String userInfo) {
		if (subject == null) {
			throw new IllegalArgumentException("No publisher found");
		}
		this.subject = subject;
		this.userInfo = userInfo;
	}


	@Override
	public void update(String description) {
		this.description = description;
		display();
	}

	private void display() {
		System.out.println("[" + userInfo + "]: " + description);
	}

	@Override
	public void subscribe() {
		System.out.println("Subscribing " + userInfo + " to " + subject.subjectDetails() + "...");
		this.subject.subscribeObserver(this);
		System.out.println("Subscribed successfully!!!");
	}

	@Override
	public void unsubscribe() {
		System.out.println("Unsubscribing " + userInfo + " to " + subject.subjectDetails() + "...");
		this.subject.unsubscribeObserver(this);
		System.out.println("Unsubscribed successfully!!!");
	}
}
