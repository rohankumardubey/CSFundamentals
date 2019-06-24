package org.redquark.csfundamentals.designpatterns.behavioral.mediator;

/**
 * @Author Anirudh Sharma
 */
public class CottonMediator implements MachineMediator {

	private final Machine machine;
	private final Heater heater;
	private final Motor motor;
	private final Sensor sensor;
	private final SoilRemoval soilRemoval;
	private final Valve valve;


	public CottonMediator(Machine machine, Heater heater, Motor motor, Sensor sensor, SoilRemoval soilRemoval, Valve valve) {
		this.machine = machine;
		this.heater = heater;
		this.motor = motor;
		this.sensor = sensor;
		this.soilRemoval = soilRemoval;
		this.valve = valve;

		System.out.println("Setting up for the COTTON program");
	}

	@Override
	public void start() {
		machine.start();
	}

	@Override
	public void wash() {
		motor.startMotor();
		motor.rotateDrum(700);
		System.out.println("Adding detergent");
		soilRemoval.low();
		System.out.println("Adding softener");
	}

	@Override
	public void open() {
		valve.open();
	}

	@Override
	public void closed() {
		valve.closed();
	}

	@Override
	public void on() {
		heater.on(40);
	}

	@Override
	public void off() {
		heater.off();
	}

	@Override
	public boolean checkTemperature(int temperature) {
		return sensor.checkTemperature(temperature);
	}
}
