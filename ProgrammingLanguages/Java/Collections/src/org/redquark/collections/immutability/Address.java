package org.redquark.collections.immutability;

/**
 * This class represents and address in the Middle Earth
 * 
 * @author Anirudh Sharma
 *
 */
public class Address {

	private String country;
	private String city;

	/**
	 * Parameterized constructor
	 */
	public Address(String country, String city) {
		this.country = country;
		this.city = city;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
}
