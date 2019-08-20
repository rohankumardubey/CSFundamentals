package org.redquark.collections.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Anirudh Sharma
 *
 */
public class CustomKeys {

	public static void main(String[] args) {

		// Testing custom object as the keys
		Map<Account, String> accountMap = new HashMap<>();

		// Creating some key objects
		Account accountOne = new Account(100);
		accountOne.setHolderName("Anirudh");
		Account accountTwo = new Account(200);
		accountTwo.setHolderName("Sharma");

		// Adding values to the map using mutable keys
		accountMap.put(accountOne, accountOne.getHolderName());
		accountMap.put(accountTwo, accountTwo.getHolderName());
		System.out.println("Original Map: " + accountMap);

		// Change the key state so that the hashcode will be calculated again
		accountOne.setHolderName("Chintu");
		accountTwo.setHolderName("TheGreat");

		// Getting values after changing state of keys
		System.out.println(accountMap.get(accountOne));
		System.out.println(accountMap.get(accountTwo));

		// Create a new key with existing account number
		Account accountThree = new Account(100);
		accountThree.setHolderName("Gogan");
		System.out.println(accountMap.get(accountThree));

	}

}

class Account {

	private int accountNumber;
	private String holderName;

	public Account(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public int getAccountNumber() {
		return this.accountNumber;
	}

	public String getHolderName() {
		return this.holderName;
	}

	public void setHolderName(String holder) {
		this.holderName = holder;
	}

	// Depends only on accountNumber - which has no setter
	// Therefore, we cannot set it via constructor and setter
	@Override
	public int hashCode() {
		final int prime = 37;
		int result = 1;
		result = prime * result + accountNumber;
		return result;
	}

	// Compare only account numbers
	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (other == null) {
			return false;
		}
		if (getClass() != other.getClass()) {
			return false;
		}

		Account account = (Account) other;
		if (accountNumber != account.accountNumber) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", holderName=" + holderName + "]";
	}
}
