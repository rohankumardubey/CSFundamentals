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
public class ComparatorExample {

	public static void main(String[] args) {

		List<Employee> employees = new ArrayList<>();

		employees.add(new Employee(1010, "Rajeev", 100000.00, LocalDate.of(2010, 7, 10)));
		employees.add(new Employee(1004, "Chris", 95000.50, LocalDate.of(2017, 3, 19)));
		employees.add(new Employee(1015, "David", 134000.00, LocalDate.of(2017, 9, 28)));
		employees.add(new Employee(1009, "Steve", 100000.00, LocalDate.of(2016, 5, 18)));

		System.out.println("Employees before sorting: " + employees);

		// Sort employees by name
		Comparator<Employee> nameComparator = new Comparator<Employee>() {

			@Override
			public int compare(Employee o1, Employee o2) {
				return o1.getName().compareTo(o2.getName());
			}
		};

		/**
		 * Java 8 way
		 * 
		 * The above Comparator can also be written using lambda expression like so =>
		 * employeeNameComparator = (e1, e2) -> e1.getName().compareTo(e2.getName());
		 * 
		 * Which can be shortened even further using Java 8 Comparator default method
		 * employeeNameComparator = Comparator.comparing(Employee::getName)
		 */

		Collections.sort(employees, nameComparator);
		System.out.println("Sorted list by name: " + employees);

		// Sort by salary
		Comparator<Employee> salaryComparator = new Comparator<Employee>() {

			@Override
			public int compare(Employee o1, Employee o2) {
				return (int) (o1.getSalary() - o2.getSalary());
			}
		};

		Collections.sort(employees, salaryComparator);
		System.out.println("Sorted list by salary: " + employees);

		// Sort by joining date
		Comparator<Employee> joiningDateComparator = new Comparator<Employee>() {

			@Override
			public int compare(Employee o1, Employee o2) {
				return o1.getJoiningDate().compareTo(o2.getJoiningDate());
			}
		};

		Collections.sort(employees, joiningDateComparator);
		System.out.println("Sorted list by joining date: " + employees);

		// Sort by id
		Comparator<Employee> idComparator = new Comparator<Employee>() {

			@Override
			public int compare(Employee o1, Employee o2) {
				return o1.getId() - o2.getId();
			}
		};

		Collections.sort(employees, idComparator);
		System.out.println("Sorted list by id: " + employees);
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
