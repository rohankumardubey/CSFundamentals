package org.redquark.csfundamentals.designpatterns.behavioral.memento;

/**
 * @Author Anirudh Sharma
 */
public class Originator {

	private double x;
	private double y;

	private String lastUndoSavepoint;
	private Caretaker caretaker;

	public Originator(double x, double y, Caretaker caretaker) {
		this.x = x;
		this.y = y;
		this.caretaker = caretaker;
		createSavepoint("INITIAL");
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public void createSavepoint(String savepointName) {
		caretaker.saveMemento(new Memento(this.x, this.y), savepointName);
		lastUndoSavepoint = savepointName;
	}

	public void undo() {
		setOriginalState(lastUndoSavepoint);
	}

	public void undo(String savepointName) {
		setOriginalState(savepointName);
	}

	public void undoAll() {
		setOriginalState("INITIAL");
		caretaker.clearSavepoints();
	}

	private void setOriginalState(String savepointName) {
		Memento memento = caretaker.getMemento(savepointName);
		this.x = memento.getX();
		this.y = memento.getY();
	}

	@Override
	public String toString() {
		return "X:" + x + ", Y:" + y;
	}
}
