package org.redquark.csfundamentals.designpatterns.behavioral.state;

/**
 * @Author Anirudh Sharma
 */
public class StateMain {

	public static void main(String[] args) {

		Robot robot = new Robot();

		robot.walk();
		robot.cook();
		robot.walk();
		robot.off();

		robot.walk();
		robot.off();
		robot.cook();
	}
}
