package org.redquark.csfundamentals.designpatterns.behavioral.mediator;

/**
 * This interface is a generic mediator. The interface contains operations call by one object to another.
 *
 * @Author Anirudh Sharma
 */
public interface MachineMediator {

	void start();

	void wash();

	void open();

	void closed();

	void on();

	void off();

	boolean checkTemperature(int temperature);
}
