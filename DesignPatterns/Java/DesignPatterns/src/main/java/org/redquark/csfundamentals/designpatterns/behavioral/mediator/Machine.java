package org.redquark.csfundamentals.designpatterns.behavioral.mediator;

/**
 * @Author Anirudh Sharma
 */
public class Machine implements Colleague {

	// Reference of the mediator
	private MachineMediator mediator;

	@Override
	public void setMediator(MachineMediator mediator) {
		this.mediator = mediator;
	}

	/**
	 * This gets called on pressing button
	 */
	public void start() {
		// This in turn will call the open method of the Valve class in order to open the Valve of the machine
		mediator.open();
	}

	/**
	 * Washes the clothes
	 */
	public void wash() {
		mediator.wash();
	}
}
