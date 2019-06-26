package org.redquark.csfundamentals.designpatterns.behavioral.state;

/**
 * @Author Anirudh Sharma
 */
public class RobotOn implements RobotState {

	private final Robot robot;

	public RobotOn(Robot robot) {
		this.robot = robot;
	}

	@Override
	public void walk() {
		System.out.println("Walking...");
	}

	@Override
	public void cook() {
		System.out.println("Cooking...");
		robot.setRobotState(robot.getRobotCook());
	}

	@Override
	public void off() {
		robot.setRobotState(robot.getRobotOff());
		System.out.println("Robot is switched off...");
	}
}
