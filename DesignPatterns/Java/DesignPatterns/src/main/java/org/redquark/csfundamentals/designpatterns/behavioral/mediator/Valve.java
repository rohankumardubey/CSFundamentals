package org.redquark.csfundamentals.designpatterns.behavioral.mediator;

/**
 * @Author Anirudh Sharma
 */
public class Valve implements Colleague {

	// Reference of the mediator
	private MachineMediator mediator;

	@Override
	public void setMediator(MachineMediator mediator) {
		this.mediator = mediator;
	}

	/**
	 * This method opens the Valve
	 */
	public void open() {
		System.out.println("Valve is opened.");
		System.out.println("Filtering water...");

		// Calling the closed method of the Valve via mediator
		mediator.closed();
	}

	/**
	 * Once the water is filled, the Valve gets closed. This method is not being closed directly. It is being closed
	 * via the mediator in the open() method above.
	 */
	public void closed() {
		System.out.println("Valve is closed.");

		// Once the water gets filled and Valve gets closed, the heater gets turned on via the mediator
		mediator.on();
	}
}
