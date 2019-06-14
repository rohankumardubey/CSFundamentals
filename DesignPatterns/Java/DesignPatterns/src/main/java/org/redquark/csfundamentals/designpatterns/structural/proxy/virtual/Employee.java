package org.redquark.csfundamentals.designpatterns.structural.proxy.virtual;

/**
 * @Author Anirudh Sharma
 */
public class Employee {

	private String name;
	private double salary;
	private String designation;

	public Employee(String name, double salary, String designation) {
		this.name = name;
		this.salary = salary;
		this.designation = designation;
	}

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	public String getDesignation() {
		return designation;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Employee{");
		sb.append("name='").append(name).append('\'');
		sb.append(", salary=").append(salary);
		sb.append(", designation='").append(designation).append('\'');
		sb.append('}');
		return sb.toString();
	}
}
