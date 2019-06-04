package org.redquark.csfundamentals.designpatterns.structural.decorator;

/**
 * @Author Anirudh Sharma
 */
public class Broccoli extends PizzaDecorator {

	// Instance of the pizza
	private Pizza pizza;

	public Broccoli(Pizza pizza) {
		this.pizza = pizza;
	}

	@Override
	public String getDescription() {
		return pizza.getDescription() + ", Broccoli (9.25)";
	}

	@Override
	public double getPrice() {
		return pizza.getPrice() + 9.25;
	}
}
