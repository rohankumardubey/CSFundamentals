package org.redquark.csfundamentals.designpatterns.behavioral.state;

/**
 * This interface contains the behavior of the Robot
 *
 * @Author Anirudh Sharma
 */
public interface RobotState {

	void walk();

	void cook();

	void off();
}
