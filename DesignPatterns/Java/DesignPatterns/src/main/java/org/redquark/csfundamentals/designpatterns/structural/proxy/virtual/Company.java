package org.redquark.csfundamentals.designpatterns.structural.proxy.virtual;

/**
 * @Author Anirudh Sharma
 */
public class Company {

	private String companyName;
	private String companyAddress;
	private String companyContactNumber;
	private ContactList contactList;

	public Company(String companyName, String companyAddress, String companyContactNumber, ContactList contactList) {
		this.companyName = companyName;
		this.companyAddress = companyAddress;
		this.companyContactNumber = companyContactNumber;
		this.contactList = contactList;

		System.out.println("Company object created...");
	}

	public String getCompanyName() {
		return companyName;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public String getCompanyContactNumber() {
		return companyContactNumber;
	}

	public ContactList getContactList() {
		return contactList;
	}
}
