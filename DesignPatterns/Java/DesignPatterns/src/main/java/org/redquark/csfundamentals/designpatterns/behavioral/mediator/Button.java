package org.redquark.csfundamentals.designpatterns.behavioral.mediator;

/**
 * @Author Anirudh Sharma
 */
public class Button implements Colleague {

	// Reference of the mediator
	private MachineMediator mediator;

	@Override
	public void setMediator(MachineMediator mediator) {
		this.mediator = mediator;
	}

	public void press() {
		System.out.println("Button pressed.");

		// This start() method of the mediator calls the start() method of machine class on behalf of the Button class.
		mediator.start();
	}
}
