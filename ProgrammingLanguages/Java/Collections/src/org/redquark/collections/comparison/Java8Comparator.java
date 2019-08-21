package org.redquark.collections.comparison;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Anirudh Sharma
 *
 */
public class Java8Comparator {

	public static void main(String[] args) {

		List<Employee> employees = new ArrayList<>();

		employees.add(new Employee(1010, "Rajeev", 100000.00, LocalDate.of(2010, 7, 10)));
		employees.add(new Employee(1004, "Chris", 95000.50, LocalDate.of(2017, 3, 19)));
		employees.add(new Employee(1015, "David", 134000.00, LocalDate.of(2017, 9, 28)));
		employees.add(new Employee(1009, "Steve", 100000.00, LocalDate.of(2016, 5, 18)));

		System.out.println("Employees before sorting: " + employees);

		// Sort employees by name
		Collections.sort(employees, Comparator.comparing(Employee::getName));
		System.out.println("Employees sorted by name: " + employees);

		// Sort by salary
		Collections.sort(employees, Comparator.comparing(Employee::getSalary));
		System.out.println("Employees sorted by salary: " + employees);

		// Sort by joining date
		Collections.sort(employees, Comparator.comparing(Employee::getJoiningDate));
		System.out.println("Employees sorted by joining date: " + employees);
		
		// Sort by id
		Collections.sort(employees, Comparator.comparingDouble(Employee::getId));
		System.out.println("Employees sorted by id: " + employees);

		// Sort by name in reverse order
		Collections.sort(employees, Comparator.comparing(Employee::getName).reversed());
		System.out.println("Employees sorted by name in the reverse order: " + employees);
		
		// Chaining multiple comparators
		// Sort by salary. If salary is same then sort by name
		Collections.sort(employees, Comparator.comparingDouble(Employee::getSalary).thenComparing(Employee::getName));
		System.out.println("Employees sorted by salary. If salary is same then sorted by name: " + employees);
	}

	private static class Employee {

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

		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}

		/**
		 * @return the salary
		 */
		public double getSalary() {
			return salary;
		}

		/**
		 * @return the joiningDate
		 */
		public LocalDate getJoiningDate() {
			return joiningDate;
		}

		@Override
		public String toString() {
			return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", joiningDate=" + joiningDate
					+ "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + id;
			result = prime * result + ((joiningDate == null) ? 0 : joiningDate.hashCode());
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			long temp;
			temp = Double.doubleToLongBits(salary);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			return result;
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
	}
}
