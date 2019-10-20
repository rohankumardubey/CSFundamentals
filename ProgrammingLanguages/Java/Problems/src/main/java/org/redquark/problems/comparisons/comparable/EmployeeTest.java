package org.redquark.problems.comparisons.comparable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Anirudh Sharma
 *
 */
public class EmployeeTest {

	public static void main(String[] args) {

		List<Employee> employees = new ArrayList<>();

		// Adding some employees
		employees.add(new Employee(1010, "Rajeev", 100000.00, LocalDate.of(2010, 7, 10)));
		employees.add(new Employee(1004, "Chris", 95000.50, LocalDate.of(2017, 3, 19)));
		employees.add(new Employee(1015, "David", 134000.00, LocalDate.of(2017, 9, 28)));

		System.out.println("Before sorting: " + employees);

		// Sort the list of employees
		Collections.sort(employees);

		System.out.println("After sorting: " + employees);
	}

}
