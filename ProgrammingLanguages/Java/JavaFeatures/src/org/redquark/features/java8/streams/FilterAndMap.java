package org.redquark.features.java8.streams;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

/**
 * This class demonstrates the use of filter and map functions in Streams
 * 
 * @author Anirudh Sharma
 *
 */
public class FilterAndMap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		List<Person> persons = new LinkedList<>();

		// Adding data to the list
		addDataToList(persons);

		// Before any operation
		System.out.println("Persons list before any operation...");
		persons.forEach(System.out::println);

		// Change all names to upper case
		System.out.println("\nChange all names to upper case...");
		List<String> uppercaseNames = changeNamesToUpperCase(persons);
		uppercaseNames.forEach(System.out::println);

		// Change all ages to double
		System.out.println("\nChange all ages to double...");
		DoubleStream doubleAges = changeAgetoDouble(persons);
		doubleAges.forEach(System.out::println);

	}

	/**
	 * This method adds data to the list
	 * 
	 * @param persons
	 * @return {@link List}
	 */
	private static List<Person> addDataToList(List<Person> persons) {

		persons.add(new Person("Sachin Tendulkar", 46));
		persons.add(new Person("Sourav Ganguly", 47));
		persons.add(new Person("Rahul Dravid", 46));
		persons.add(new Person("VVS Laxman", 45));
		persons.add(new Person("Anil Kumble", 48));

		return persons;
	}

	/**
	 * This method converts all the names in the list to the uppercase
	 * 
	 * @param persons
	 * @return {@link List}
	 */
	private static List<String> changeNamesToUpperCase(List<Person> persons) {

		return persons.stream().map(item -> item.getName().toUpperCase()).collect(Collectors.toList());
	}

	/**
	 * This method returns the list of all ages converted to double
	 * 
	 * @param persons
	 * @return {@link DoubleStream}
	 */
	private static DoubleStream changeAgetoDouble(List<Person> persons) {

		return persons.stream().mapToDouble(item -> item.getAge());
	}

	/**
	 * Person model class
	 * 
	 * @author Anirudh Sharma
	 */
	private static class Person {

		private String name;
		private int age;

		/**
		 * @param name
		 * @param age
		 */
		public Person(String name, int age) {
			super();
			this.name = name;
			this.age = age;
		}

		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}

		/**
		 * @return the age
		 */
		public int getAge() {
			return age;
		}

		@Override
		public String toString() {
			return "Person [name=" + name + ", age=" + age + "]";
		}
	}
}
