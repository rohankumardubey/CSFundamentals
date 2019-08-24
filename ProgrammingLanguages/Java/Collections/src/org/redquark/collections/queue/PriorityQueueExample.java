package org.redquark.collections.queue;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Anirudh Sharma
 *
 */
public class PriorityQueueExample {

	public static void main(String[] args) {

		// Creating a employees
		Queue<Employee> employees = new PriorityQueue<>();

		// Adding some data to the queue - The data will be stored in the Queue in the
		// natural order
		employees = addData(employees);
		System.out.println("Iterate queue elements in the natural order");
		iterateQueue(employees);

		// Custom ordering of the Queue - depending on the Comparator
		Comparator<Employee> nameSorter = Comparator.comparing(Employee::getName);

		Queue<Employee> employeesByName = new PriorityQueue<>(nameSorter);

		// Elements will be added in the sorting order of names
		employeesByName = addData(employeesByName);
		System.out.println("Iterate queue elements in the sorting order of names");
		iterateQueue(employeesByName);

	}

	private static Queue<Employee> addData(Queue<Employee> employees) {

		// Adding some data to the queue - The data will be stored in the Queue in the
		// natural order
		employees.add(new Employee(1L, "AAA", LocalDate.now()));
		employees.add(new Employee(4L, "CCC", LocalDate.now()));
		employees.add(new Employee(5L, "BBB", LocalDate.now()));
		employees.add(new Employee(2L, "FFF", LocalDate.now()));
		employees.add(new Employee(3L, "DDD", LocalDate.now()));
		employees.add(new Employee(6L, "EEE", LocalDate.now()));

		return employees;
	}

	private static void iterateQueue(Queue<Employee> employees) {

		while (true) {
			// Polling the data from the queue
			Employee employee = employees.poll();

			if (employee == null) {
				break;
			}

			System.out.println(employee);
		}
	}

	private static class Employee implements Comparable<Employee> {

		private Long id;
		private String name;
		private LocalDate joiningDate;

		public Employee(Long id, String name, LocalDate joiningDate) {
			this.id = id;
			this.name = name;
			this.joiningDate = joiningDate;
		}

		/**
		 * @return the id
		 */
		public Long getId() {
			return id;
		}

		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}

		@Override
		public String toString() {
			return "Employee [id=" + id + ", name=" + name + ", joiningDate=" + joiningDate + "]";
		}

		@Override
		public int compareTo(Employee o) {
			return this.getId().compareTo(o.getId());
		}

	}
}
