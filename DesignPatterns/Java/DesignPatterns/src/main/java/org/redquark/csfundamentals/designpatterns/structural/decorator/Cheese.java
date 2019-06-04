package org.redquark.csfundamentals.designpatterns.structural.decorator;

/**
 * @Author Anirudh Sharma
 */
public class Cheese extends PizzaDecorator {

	// Instance of pizza
	private Pizza pizza;

	public Cheese(Pizza pizza) {
		this.pizza = pizza;
	}

	@Override
	public String getDescription() {
		return pizza.getDescription() + ", Cheese (25.0)";
	}

	@Override
	public double getPrice() {
		return pizza.getPrice() + 25.0;
	}


}
