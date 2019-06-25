package org.redquark.csfundamentals.designpatterns.behavioral.observer;

import java.util.List;

/**
 * @Author Anirudh Sharma
 */
public class CommentaryImpl implements Subject, Commentary {

	private final List<Observer> observers;
	private final String subjectDetails;
	private String description;

	public CommentaryImpl(List<Observer> observers, String subjectDetails) {
		this.observers = observers;
		this.subjectDetails = subjectDetails;
	}

	@Override
	public void setDescription(String description) {
		this.description = description;
		notifyObservers();
	}

	@Override
	public void subscribeObserver(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void unsubscribeObserver(Observer observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		System.out.println();
		for (Observer observer : observers) {
			observer.update(description);
		}
	}

	@Override
	public String subjectDetails() {
		return subjectDetails;
	}
}
