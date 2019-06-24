package org.redquark.csfundamentals.designpatterns.behavioral.mediator;

/**
 * @Author Anirudh Sharma
 */
public class Heater implements Colleague {

	private MachineMediator mediator;

	@Override
	public void setMediator(MachineMediator mediator) {
		this.mediator = mediator;
	}

	/**
	 * This method switches on the heater and sets the temperature as required. If the temperature reaches at a
	 * certain level it switches off the heater. The turning off of heater is done via mediator.
	 *
	 * @param temp - required temperature
	 */
	public void on(int temp) {
		System.out.println("Heater is on...");
		if (mediator.checkTemperature(temp)) {
			System.out.println("Temperature is set to: " + temp);

			// Calls the turn off method of the heater via the mediator
			mediator.off();
		}
	}

	/**
	 * Turns off the heater. Once it is turned off, it calls the wash method of the machine via the mediator.
	 */
	public void off() {
		System.out.println("Heater is off...");
		mediator.wash();
	}
}
