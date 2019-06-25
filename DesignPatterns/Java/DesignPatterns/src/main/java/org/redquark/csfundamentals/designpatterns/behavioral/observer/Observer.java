package org.redquark.csfundamentals.designpatterns.behavioral.observer;

/**
 * @Author Anirudh Sharma
 */
public interface Observer {

	/**
	 * This method is called by the subject on the observer in order to notify it, when there is a change in the
	 * state of the subject.
	 */
	void update(String description);

	/**
	 * This method is used to subscribe itself with the subject.
	 */
	void subscribe();

	/**
	 * This method is used to unsubscribe itself with the subject.
	 */
	void unsubscribe();
}
