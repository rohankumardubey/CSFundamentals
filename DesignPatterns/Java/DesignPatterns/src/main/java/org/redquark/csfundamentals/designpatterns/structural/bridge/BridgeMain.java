package org.redquark.csfundamentals.designpatterns.structural.bridge;

/**
 * @Author Anirudh Sharma
 */
public class BridgeMain {

	public static void main(String[] args) {

		Product productOne = new CentralLocking("Central Locking System");
		Product productTwo = new GearLocking("Gear Locking System");

		Car car = new BigWheel(productOne, "BigWheel XZ Model");
		car.produceProduct();
		car.assemble();
		car.printDetails();

		System.out.println("\n******************************\n");

		car = new BigWheel(productTwo, "BigWheel XZ Model");
		car.produceProduct();
		car.assemble();
		car.printDetails();

		System.out.println("\n******************************\n");

		car = new Motoren(productOne, "Motoren LM Model");
		car.produceProduct();
		car.assemble();
		car.printDetails();

		System.out.println("\n******************************\n");

		car = new Motoren(productTwo, "Motoren LM Model");
		car.produceProduct();
		car.assemble();
		car.printDetails();
	}
}
