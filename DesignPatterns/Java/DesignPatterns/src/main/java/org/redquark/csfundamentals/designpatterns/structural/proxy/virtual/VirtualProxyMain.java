package org.redquark.csfundamentals.designpatterns.structural.proxy.virtual;

import java.util.List;

/**
 * @Author Anirudh Sharma
 */
public class VirtualProxyMain {

	public static void main(String[] args) {

		ContactList contactList = new ContactListProxyImpl();

		Company company = new Company("ABC Company",
				"India", "+91=1234567890", contactList);

		System.out.println("Company Name: " + company.getCompanyName());
		System.out.println("Company Address: " + company.getCompanyAddress());
		System.out.println("Company Contact No.: " + company.getCompanyContactNumber());

		System.out.println("Requesting for contact list");
		contactList = company.getContactList();

		List<Employee> employees = contactList.getEmployeeList();

		for (Employee employee : employees) {
			System.out.println(employee);
		}
	}
}
