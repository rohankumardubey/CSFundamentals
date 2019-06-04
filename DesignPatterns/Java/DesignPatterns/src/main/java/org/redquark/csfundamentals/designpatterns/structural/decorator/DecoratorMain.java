package org.redquark.csfundamentals.designpatterns.structural.decorator;

import java.text.DecimalFormat;

/**
 * @Author Anirudh Sharma
 */
public class DecoratorMain {

	public static void main(String[] args) {

		DecimalFormat decimalFormat = new DecimalFormat("#.##");

		// Veg pizza
		Pizza pizza = new VegPizza();

		// Adding toppings
		pizza = new Cheese(pizza);
		pizza = new Broccoli(pizza);

		System.out.println("Description: " + pizza.getDescription());
		System.out.println("Price: " + decimalFormat.format(pizza.getPrice()));

		// Non veg pizza
		pizza = new NonVegPizza();

		// Adding toppings
		pizza = new Chicken(pizza);
		pizza = new Ham(pizza);

		System.out.println("Description: " + pizza.getDescription());
		System.out.println("Price: " + decimalFormat.format(pizza.getPrice()));
	}
}
