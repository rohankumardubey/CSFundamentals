package org.redquark.collections.queue;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author Anirudh Sharma
 *
 */
public class PriorityBlockingQueueExample {

	public static void main(String[] args) {

		// Creating a Queue
		PriorityBlockingQueue<Employee> employees = new PriorityBlockingQueue<>();

		// Adding some data to the queue - The data will be stored in the Queue in the
		// natural order
		employees = addData(employees);
		System.out.println("Iterate queue elements in the natural order");
		iterateQueue(employees);

		// Custom ordering of the Queue - depending on the Comparator
		Comparator<Employee> nameSorter = Comparator.comparing(Employee::getName);

		PriorityBlockingQueue<Employee> employeesByName = new PriorityBlockingQueue<>(11, nameSorter);

		// Elements will be added in the sorting order of names
		employeesByName = addData(employeesByName);
		System.out.println("\nIterate queue elements in the sorting order of names");
		iterateQueue(employeesByName);
		
		// drainTo examples
		List<Employee> employeeList = new LinkedList<>();
		employees = addData(employees);
		
		// Drain first 3 elements
		employees.drainTo(employeeList, 3);
		System.out.println("\nFirst 3 elements from PriorityBlockingQueue to a List =>" + employeeList);
		
		// Drain all elements
		employees.drainTo(employeeList);
		System.out.println("\nAll elements to List =>" + employeeList);
	}

	private static PriorityBlockingQueue<Employee> addData(PriorityBlockingQueue<Employee> employees) {

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
