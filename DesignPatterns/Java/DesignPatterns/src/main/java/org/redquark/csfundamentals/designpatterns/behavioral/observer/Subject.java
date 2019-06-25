package org.redquark.csfundamentals.designpatterns.behavioral.observer;

/**
 * @Author Anirudh Sharma
 */
public interface Subject {

	/**
	 * This method is used to subscribe observers or we can say register the observers so that if there is a change
	 * in the state of the subject, all these observers should get notified.
	 */
	void subscribeObserver(Observer observer);

	/**
	 * This method is used to unsubscribe observers so that if there is a change in the state of the subject, this
	 * unsubscribed observer should not get notified.
	 */
	void unsubscribeObserver(Observer observer);

	/**
	 * This method notifies the registered observers when there is a change in the state of the subject.
	 */
	void notifyObservers();

	/**
	 * Optional method - it can be according to your need or specific requirement
	 *
	 * @return String
	 */
	String subjectDetails();
}
