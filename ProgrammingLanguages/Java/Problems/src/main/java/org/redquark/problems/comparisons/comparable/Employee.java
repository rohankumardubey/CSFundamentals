package org.redquark.problems.comparisons.comparable;

import java.time.LocalDate;
import java.util.Objects;

/**
 * @author Anirudh Sharma
 *
 */
public class Employee implements Comparable<Employee> {

	private int id;
	private String name;
	private double salary;
	private LocalDate joiningDate;

	public Employee(int id, String name, double salary, LocalDate joiningDate) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.joiningDate = joiningDate;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the salary
	 */
	public double getSalary() {
		return salary;
	}

	/**
	 * @param salary the salary to set
	 */
	public void setSalary(double salary) {
		this.salary = salary;
	}

	/**
	 * @return the joiningDate
	 */
	public LocalDate getJoiningDate() {
		return joiningDate;
	}

	/**
	 * @param joiningDate the joiningDate to set
	 */
	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}

	/**
	 * Compare two employees based on their IDs
	 */
	@Override
	public int compareTo(Employee o) {
		return this.getId() - o.getId();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Employee employee = (Employee) o;
		return id == employee.id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public String toString() {
		return "Employee { id = " + id + ", name = " + name + ", salary = " + salary + ", joiningDate = " + joiningDate
				+ " }";
	}

}
