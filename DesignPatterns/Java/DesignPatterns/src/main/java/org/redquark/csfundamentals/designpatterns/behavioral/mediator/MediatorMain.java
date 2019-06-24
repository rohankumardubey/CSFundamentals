package org.redquark.csfundamentals.designpatterns.behavioral.mediator;

/**
 * @Author Anirudh Sharma
 */
public class MediatorMain {

	public static void main(String[] args) {

		MachineMediator mediator;
		Sensor sensor = new Sensor();
		SoilRemoval soilRemoval = new SoilRemoval();
		Motor motor = new Motor();
		Machine machine = new Machine();
		Heater heater = new Heater();
		Valve valve = new Valve();
		Button button = new Button();

		mediator = new CottonMediator(machine, heater, motor, sensor, soilRemoval, valve);

		button.setMediator(mediator);
		machine.setMediator(mediator);
		heater.setMediator(mediator);
		valve.setMediator(mediator);
		button.press();

		mediator = new DenimMediator(machine, heater, motor, sensor, soilRemoval, valve);
		button.setMediator(mediator);
		machine.setMediator(mediator);
		heater.setMediator(mediator);
		valve.setMediator(mediator);
		button.press();
	}
}
