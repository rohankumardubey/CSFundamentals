package org.redquark.collections.comparison;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * @author Anirudh Sharma
 *
 */
public class ComparableExample {

	public static void main(String[] args) {

		List<Employee> employees = new ArrayList<>();

		employees.add(new Employee(1010, "Rajeev", 100000.00, LocalDate.of(2010, 7, 10)));
		employees.add(new Employee(1004, "Chris", 95000.50, LocalDate.of(2017, 3, 19)));
		employees.add(new Employee(1015, "David", 134000.00, LocalDate.of(2017, 9, 28)));

		System.out.println("Employees (Before Sorting) : " + employees);

		// Sort employees
		Collections.sort(employees);

		System.out.println("Employees (After Sorting) : " + employees);
	}

	private static class Employee implements Comparable<Employee> {

		private int id;
		private String name;
		private double salary;
		private LocalDate joiningDate;

		public Employee(int id, String name, double salary, LocalDate joiningDate) {
			super();
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

		@Override
		public String toString() {
			return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", joiningDate=" + joiningDate
					+ "]";
		}

		@Override
		public int hashCode() {
			return Objects.hash(id);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Employee other = (Employee) obj;
			if (id != other.id)
				return false;
			if (joiningDate == null) {
				if (other.joiningDate != null)
					return false;
			} else if (!joiningDate.equals(other.joiningDate))
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			if (Double.doubleToLongBits(salary) != Double.doubleToLongBits(other.salary))
				return false;
			return true;
		}

		/**
		 * Compare two employees based on their id
		 */
		@Override
		public int compareTo(Employee o) {
			return this.getId() - o.getId();
		}

	}
}
