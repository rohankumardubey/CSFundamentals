package org.redquark.csfundamentals.designpatterns.structural.bridge;

/**
 * @Author Anirudh Sharma
 */
public class BigWheel extends Car {

	private final Product product;
	private final String carType;

	protected BigWheel(Product product, String carType) {
		super(product, carType);
		this.product = product;
		this.carType = carType;
	}

	@Override
	public void produceProduct() {
		product.produce();
		System.out.println("Modifying product " + product.productName() + " according to " + carType);
	}

	@Override
	public void assemble() {
		System.out.println("Assembling " + product.productName() + " for " + carType);
	}
}
