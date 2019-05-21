package org.redquark.csfundamentals.designpatterns.creational.builder;

/**
 * @Author Anirudh Sharma
 */
public class BuilderMain {

	public static void main(String[] args) {

		CarBuilder carBuilder = new SedanCarBuilder();
		CarDirector carDirector = new CarDirector(carBuilder);
		carDirector.build();
		Car car = carBuilder.getCar();
		System.out.println(car);

		carBuilder = new SportsCarBuilder();
		carDirector = new CarDirector(carBuilder);
		carDirector.build();
		car = carBuilder.getCar();
		System.out.println(car);

	}
}
