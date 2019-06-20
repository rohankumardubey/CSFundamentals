package org.redquark.features.java8.comparator;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Anirudh Sharma
 *
 */
public class ComparatorLambdaExample {

	/**
	 * This method returns the list of developers
	 * 
	 * @return List<Developers>
	 */
	private static List<Developer> getDevelopers() {

		// Initializing the list
		List<Developer> developers = new LinkedList<>();

		// Adding developer details in the list
		developers.add(new Developer("Tormund Giantsbane", "Java", 10000.0, 32));
		developers.add(new Developer("Jaime Lannister", "CPP", 12500.0, 33));
		developers.add(new Developer("Rhaegar Targeryn", "Python", 15000.0, 31));
		developers.add(new Developer("Eddard Stark", "JavaScript", 13750.0, 28));
		developers.add(new Developer("Mance Rayder", "Ruby", 11250.0, 29));

		return developers;
	}

	/**
	 * This method prints the list of developers
	 * 
	 * @param developers
	 */
	private static void printDevelopers(List<Developer> developers) {
		developers.forEach((developer) -> System.out.println(developer));
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		List<Developer> developers = getDevelopers();

		System.out.println("Before sorting...");
		printDevelopers(developers);

		// Sort by name
		developers.sort((Developer o1, Developer o2) -> o1.getName().compareTo(o2.getName()));
		System.out.println("\nAfter sorting by name...");
		printDevelopers(developers);

		// Sort by technology
		developers.sort((Developer o1, Developer o2) -> o1.getTechnology().compareTo(o2.getTechnology()));
		System.out.println("\nAfter sorting by technology...");
		printDevelopers(developers);

		// Sort by salary
		developers.sort((Developer o1, Developer o2) -> (int) (o1.getSalary() - o2.getSalary()));
		System.out.println("\nAfter sorting by salary...");
		printDevelopers(developers);

		// Sort by age
		developers.sort((Developer o1, Developer o2) -> o1.getAge() - o2.getAge());
		System.out.println("\nAfter sorting by age...");
		printDevelopers(developers);
	}

}
