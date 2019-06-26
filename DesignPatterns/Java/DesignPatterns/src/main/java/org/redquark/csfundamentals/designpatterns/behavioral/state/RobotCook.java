package org.redquark.csfundamentals.designpatterns.behavioral.state;

/**
 * @Author Anirudh Sharma
 */
public class RobotCook implements RobotState {

	private final Robot robot;

	public RobotCook(Robot robot) {
		this.robot = robot;
	}

	@Override
	public void walk() {
		System.out.println("Walking...");
		robot.setRobotState(robot.getRobotOn());
	}

	@Override
	public void cook() {
		System.out.println("Cooking...");
	}

	@Override
	public void off() {
		System.out.println("Cannot switched off while cooking...");
	}
}
