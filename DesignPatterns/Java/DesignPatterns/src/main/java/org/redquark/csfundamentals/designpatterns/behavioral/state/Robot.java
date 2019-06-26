package org.redquark.csfundamentals.designpatterns.behavioral.state;

/**
 * @Author Anirudh Sharma
 */
public class Robot implements RobotState {

	private RobotState robotOn;
	private RobotState robotCook;
	private RobotState robotOff;
	private RobotState robotState;

	public Robot() {
		this.robotOn = new RobotOn(this);
		this.robotOff = new RobotOff(this);
		this.robotCook = new RobotCook(this);
		this.robotState = robotOn;
	}

	@Override
	public void walk() {
		robotState.walk();
	}

	@Override
	public void cook() {
		robotState.cook();
	}

	@Override
	public void off() {
		robotState.off();
	}

	public RobotState getRobotOn() {
		return robotOn;
	}

	public void setRobotOn(RobotState robotOn) {
		this.robotOn = robotOn;
	}

	public RobotState getRobotCook() {
		return robotCook;
	}

	public void setRobotCook(RobotState robotCook) {
		this.robotCook = robotCook;
	}

	public RobotState getRobotOff() {
		return robotOff;
	}

	public void setRobotOff(RobotState robotOff) {
		this.robotOff = robotOff;
	}

	public RobotState getRobotState() {
		return robotState;
	}

	public void setRobotState(RobotState state) {
		this.robotState = state;
	}
}
