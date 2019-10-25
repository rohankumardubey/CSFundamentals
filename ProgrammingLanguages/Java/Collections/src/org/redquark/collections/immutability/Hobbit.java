package org.redquark.collections.immutability;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anirudh Sharma
 *
 */
public final class Hobbit {

	// Make all the instance variable final
	private final String name;
	private final Address address;
	private final List<String> stuff;

	/**
	 * All argument constructor - so that our client can set the values of fields
	 * once We need to initialize non-primitive mutable fields using the Deep Copy
	 * principle as when we pass the value of an object, we are passing its
	 * reference to it and not the actual entity. So state of these type of objects
	 * can be changed and may have side-effects.
	 */
	public Hobbit(String name, Address address, List<String> stuff) {
		this.name = name;
		// Deep copy of the Address object
		this.address = new Address(address.getCountry(), address.getCity());
		// Deep copy of the stuff object
		this.stuff = new ArrayList<>(stuff);
	}

	/***************************************************************************************************
	 * Only getters - so that someone cannot set the properties after initialization
	 * via the constructor.
	 * 
	 * These getters should also return the deep copy of the non-primitive mutable
	 * objects
	 ***************************************************************************************************/
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the address
	 */
	public Address getAddress() {
		return new Address(address.getCountry(), address.getCity());
	}

	/**
	 * @return the stuff
	 */
	public List<String> getStuff() {
		return new ArrayList<>(stuff);
	}

}
