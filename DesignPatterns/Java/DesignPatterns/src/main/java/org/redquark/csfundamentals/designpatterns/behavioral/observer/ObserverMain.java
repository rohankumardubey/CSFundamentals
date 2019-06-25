package org.redquark.csfundamentals.designpatterns.behavioral.observer;

import java.util.LinkedList;

/**
 * @Author Anirudh Sharma
 */
public class ObserverMain {

	public static void main(String[] args) {

		Subject subject = new CommentaryImpl(new LinkedList<>(), "Soccer Match");
		Observer observer = new SMS(subject, "John Doe [New York]");
		observer.subscribe();

		System.out.println();
		Observer observer2 = new SMS(subject, "Tim Ronney [London]");
		observer2.subscribe();

		Commentary cObject = ((Commentary) subject);
		cObject.setDescription("Welcome to live Soccer match");
		cObject.setDescription("Current score 0-0");
		System.out.println();

		observer2.unsubscribe();
		System.out.println();

		cObject.setDescription("It’s a goal!!");
		cObject.setDescription("Current score 1-0");
		System.out.println();

		Observer observer3 = new SMS(subject, "Marrie [Paris]");
		observer3.subscribe();
		System.out.println();

		cObject.setDescription("It’s another goal!!");
		cObject.setDescription("Half-time score 2-0");
	}
}
