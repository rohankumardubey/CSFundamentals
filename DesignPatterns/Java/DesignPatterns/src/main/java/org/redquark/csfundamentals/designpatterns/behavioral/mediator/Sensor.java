package org.redquark.csfundamentals.designpatterns.behavioral.mediator;

/**
 * @Author Anirudh Sharma
 */
public class Sensor {

	public boolean checkTemperature(int temp) {
		System.out.println("Temperature reached " + temp + " degree celsius");
		return true;
	}

}
