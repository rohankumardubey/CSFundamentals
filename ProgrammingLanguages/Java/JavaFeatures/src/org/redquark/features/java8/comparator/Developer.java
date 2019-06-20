package org.redquark.features.java8.comparator;

/**
 * Model class for developers
 * 
 * @author Anirudh Sharma
 *
 */
public class Developer {

	private String name;
	private String technology;
	private double salary;
	private int age;

	/**
	 * @param name
	 * @param technology
	 * @param salary
	 * @param age
	 */
	public Developer(String name, String technology, double salary, int age) {
		super();
		this.name = name;
		this.technology = technology;
		this.salary = salary;
		this.age = age;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the technology
	 */
	public String getTechnology() {
		return technology;
	}

	/**
	 * @return the salary
	 */
	public double getSalary() {
		return salary;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return "Developer [name=" + name + ", technology=" + technology + ", salary=" + salary + ", age=" + age + "]";
	}

}
