package org.redquark.features.java8.streams;

import java.util.LinkedList;
import java.util.List;

/**
 * This class demonstrates the use of filter, findAny and orElse functions
 * 
 * @author Anirudh Sharma
 *
 */
public class FilterFindAnyAndOrElse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		List<Person> persons = new LinkedList<>();

		// Adding data to the list
		addDataToList(persons);

		// Find the person by their name and age using conventional way
		System.out.println("Finding the person using the conventional way...");
		System.out.println(findByConventionalWay(persons, "Sachin Tendulkar", 46));

		// Find the person by their name and age using the Java 8 way
		System.out.println("\nFinding the person using Java 8 way...");
		System.out.println(findByJava8Way(persons, "VVS Laxman", 45));

	}

	/**
	 * This method adds data to the list
	 * 
	 * @param persons
	 * @return List of persons
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
	 * This method will find the person for the specified name and age using the
	 * conventional (before Java 8) way
	 * 
	 * @param persons
	 * @param name
	 * @param age
	 * @return Person with the specified age and name
	 */
	private static Person findByConventionalWay(List<Person> persons, String name, int age) {

		// Temporary object
		Person tempPerson = null;

		// Loop for all the items in the list
		for (Person person : persons) {

			// Check if the name and age specified equal to the one of the persons in the
			// list
			if (name.equals(person.getName()) && age == person.getAge()) {
				tempPerson = person;
			}
		}

		return tempPerson;
	}

	/**
	 * This method returns the person with the specified name and age using the Java
	 * 8 way
	 * 
	 * @param persons
	 * @param name
	 * @param age
	 * @return Person based on specified name and age
	 */
	private static Person findByJava8Way(List<Person> persons, String name, int age) {

		return persons.stream().filter(item -> item.getName().equals(name) && item.getAge() == age).findAny()
				.orElse(null);
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
