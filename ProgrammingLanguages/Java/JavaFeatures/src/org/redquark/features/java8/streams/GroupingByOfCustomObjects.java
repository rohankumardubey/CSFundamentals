package org.redquark.features.java8.streams;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Anirudh Sharma
 *
 */
public class GroupingByOfCustomObjects {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Getting list of fruits
		List<Fruit> fruits = addData();

		// Group by count
		System.out.println("Group by count: " + groupByCount(fruits));

		// Group by sum of quantity
		System.out.println("Group by sum of quantity: " + groupBySumOfQuantity(fruits));

		// Group by price
		System.out.println("Group by price: " + groupByPrice(fruits));
	}

	/**
	 * This method returns the list of Fruit items
	 * 
	 * @param fruits
	 * @return {@link List}
	 */
	private static List<Fruit> addData() {

		// Adding data to the list
		List<Fruit> fruits = Arrays.asList(new Fruit("Apple", 10, new BigDecimal("9.99")),
				new Fruit("Banana", 20, new BigDecimal("19.99")), new Fruit("Orange", 10, new BigDecimal("29.99")),
				new Fruit("Watermelon", 10, new BigDecimal("29.99")), new Fruit("Papaya", 20, new BigDecimal("9.99")),
				new Fruit("Apple", 10, new BigDecimal("9.99")), new Fruit("Banana", 10, new BigDecimal("19.99")),
				new Fruit("Apple", 20, new BigDecimal("9.99")));

		return fruits;
	}

	/**
	 * This method returns the map of fruits based on count
	 * 
	 * @param fruits
	 * @return {@link Map}
	 */
	private static Map<String, Long> groupByCount(List<Fruit> fruits) {

		Map<String, Long> groupedByCountMap = fruits.stream()
				.collect(Collectors.groupingBy(Fruit::getName, Collectors.counting()));

		return groupedByCountMap;
	}

	/**
	 * This method returns the total quantities of each fruit
	 * 
	 * @param fruits
	 * @return {@link Map}
	 */
	private static Map<String, Integer> groupBySumOfQuantity(List<Fruit> fruits) {

		Map<String, Integer> groupBySumOfQuantityMap = fruits.stream()
				.collect(Collectors.groupingBy(Fruit::getName, Collectors.summingInt(Fruit::getQuantity)));

		return groupBySumOfQuantityMap;
	}

	/**
	 * This method groups the same priced fruits together
	 * 
	 * @param fruits
	 * @return {@link Map}
	 */
	private static Map<BigDecimal, Set<String>> groupByPrice(List<Fruit> fruits) {

		Map<BigDecimal, Set<String>> groupByPriceMap = fruits.stream().collect(
				Collectors.groupingBy(Fruit::getPrice, Collectors.mapping(Fruit::getName, Collectors.toSet())));

		return groupByPriceMap;
	}

	private static class Fruit {

		private String name;
		private int quantity;
		private BigDecimal price;

		/**
		 * @param name
		 * @param quantity
		 * @param price
		 */
		public Fruit(String name, int quantity, BigDecimal price) {
			super();
			this.name = name;
			this.quantity = quantity;
			this.price = price;
		}

		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}

		/**
		 * @return the quantity
		 */
		public int getQuantity() {
			return quantity;
		}

		/**
		 * @return the price
		 */
		public BigDecimal getPrice() {
			return price;
		}

		@Override
		public String toString() {
			return "Fruit [name=" + name + ", quantity=" + quantity + ", price=" + price + "]";
		}
	}
}
