package org.redquark.csfundamentals.designpatterns.behavioral.state;

/**
 * @Author Anirudh Sharma
 */
public class RobotOff implements RobotState {

	private final Robot robot;

	public RobotOff(Robot robot) {
		this.robot = robot;
	}

	@Override
	public void walk() {
		System.out.println("Walking...");
		robot.setRobotState(robot.getRobotOn());
	}

	@Override
	public void cook() {
		System.out.println("Cannot cook at off state");
	}

	@Override
	public void off() {
		System.out.println("Already switched off");
	}
}
