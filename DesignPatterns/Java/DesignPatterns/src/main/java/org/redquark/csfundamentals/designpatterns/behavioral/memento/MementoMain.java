package org.redquark.csfundamentals.designpatterns.behavioral.memento;

/**
 * @Author Anirudh Sharma
 */
public class MementoMain {

	public static void main(String[] args) {

		Caretaker caretaker = new Caretaker();
		Originator originator = new Originator(5, 10, caretaker);

		System.out.println("Default state: " + originator);

		originator.setX(originator.getY() * 20);

		System.out.println("State: " + originator);
		originator.createSavepoint("SAVE1");

		originator.setY(originator.getX() / 10.0);
		System.out.println("Sate:" + originator);

		originator.undo();
		System.out.println("State after undo: " + originator);

		originator.setX(Math.pow(originator.getX(), 3));
		originator.createSavepoint("SAVE2");
		System.out.println("State: " + originator);
		originator.setY(originator.getX() - 30);
		originator.createSavepoint("SAVE3");
		System.out.println("State: " + originator);
		originator.setY(originator.getX() / 22);
		originator.createSavepoint("SAVE4");
		System.out.println("State: " + originator);
		originator.undo("SAVE2");
		System.out.println("Retrieving at: " + originator);
		originator.undoAll();
		System.out.println("State after undo all: " + originator);

	}
}
