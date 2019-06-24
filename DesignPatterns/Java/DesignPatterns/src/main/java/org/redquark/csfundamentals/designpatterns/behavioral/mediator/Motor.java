package org.redquark.csfundamentals.designpatterns.behavioral.mediator;

/**
 * @Author Anirudh Sharma
 */
public class Motor {

	public void startMotor() {
		System.out.println("Start motor...");
	}

	public void rotateDrum(int rpm) {
		System.out.println("Rotating drum at " + rpm + " rpm");
	}
}
