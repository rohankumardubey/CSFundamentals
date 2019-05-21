package org.redquark.csfundamentals.designpatterns.creational.builder;

/**
 * @Author Anirudh Sharma
 */
public class CarDirector {

	private CarBuilder carBuilder;

	public CarDirector(CarBuilder carBuilder) {
		this.carBuilder = carBuilder;
	}

	public void build() {
		carBuilder.buildBodyStyle();
		carBuilder.buildPower();
		carBuilder.buildEngine();
		carBuilder.buildBreaks();
		carBuilder.buildSeats();
		carBuilder.buildWindows();
		carBuilder.buildFuelType();
	}
}
