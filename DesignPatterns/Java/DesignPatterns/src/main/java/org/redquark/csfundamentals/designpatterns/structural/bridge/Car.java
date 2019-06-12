package org.redquark.csfundamentals.designpatterns.structural.bridge;

public abstract class Car {

	private final Product product;
	private final String carType;

	protected Car(Product product, String carType) {
		this.product = product;
		this.carType = carType;
	}

	public abstract void produceProduct();

	public abstract void assemble();

	/**
	 * Prints the details of the car
	 */
	public void printDetails() {
		System.out.println("Car: " + carType + ", Product: " + product.productName());
	}
}
