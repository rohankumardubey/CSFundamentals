package org.redquark.problems.comparisons.comparator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Anirudh Sharma
 *
 */
public class EmployeeTest {

	public static void main(String[] args) {

		List<Employee> employees = new ArrayList<>();

		employees.add(new Employee(1010, "Rajeev", 100000.00, LocalDate.of(2010, 7, 10)));
		employees.add(new Employee(1004, "Chris", 95000.50, LocalDate.of(2017, 3, 19)));
		employees.add(new Employee(1015, "David", 134000.00, LocalDate.of(2017, 9, 28)));
		employees.add(new Employee(1009, "Steve", 100000.00, LocalDate.of(2016, 5, 18)));

		System.out.println("Before any sorting: " + employees);

		// Sort by names
		Comparator<Employee> nameComparator = new Comparator<>() {

			@Override
			public int compare(Employee o1, Employee o2) {
				return o1.getName().compareTo(o2.getName());
			}

		};

		Collections.sort(employees, nameComparator);
		System.out.println("Sorted by names: " + employees);

		// Sort by salary
		Comparator<Employee> salaryComparator = new Comparator<>() {

			@Override
			public int compare(Employee o1, Employee o2) {
				return (int) (o1.getSalary() - o2.getSalary());
			}
		};

		Collections.sort(employees, salaryComparator);
		System.out.println("Sorted by salaries: " + employees);

		// Sort by joining date
		Comparator<Employee> joiningDateComparator = new Comparator<>() {

			@Override
			public int compare(Employee o1, Employee o2) {
				return o1.getJoiningDate().compareTo(o2.getJoiningDate());
			}
		};

		Collections.sort(employees, joiningDateComparator);
		System.out.println("Sorted by joining dates: " + employees);
	}

}
