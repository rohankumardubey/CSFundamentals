package org.redquark.csfundamentals.designpatterns.structural.decorator;

/**
 * @Author Anirudh Sharma
 */
public class Chicken extends PizzaDecorator {

	// Instance of the pizza
	private Pizza pizza;

	public Chicken(Pizza pizza) {
		this.pizza = pizza;
	}

	@Override
	public String getDescription() {
		return pizza.getDescription() + ", Chicken (46.7)";
	}

	@Override
	public double getPrice() {
		return pizza.getPrice() + 46.7;
	}
}
