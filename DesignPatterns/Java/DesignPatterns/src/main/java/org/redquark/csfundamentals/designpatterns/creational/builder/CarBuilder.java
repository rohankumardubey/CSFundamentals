package org.redquark.csfundamentals.designpatterns.creational.builder;

/**
 * @Author Anirudh Sharma
 */
public interface CarBuilder {

	void buildBodyStyle();

	void buildPower();

	void buildEngine();

	void buildBreaks();

	void buildSeats();

	void buildWindows();

	void buildFuelType();

	Car getCar();
}
