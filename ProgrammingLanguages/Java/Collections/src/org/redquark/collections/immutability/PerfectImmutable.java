package org.redquark.collections.immutability;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anirudh Sharma
 *
 */
public class PerfectImmutable {

	public static void main(String[] args) {

		Address address = new Address("Hobbiton", "Shire");

		List<String> stuff = new ArrayList<>();
		stuff.add("Sword");
		stuff.add("Ring of Power");

		Hobbit hobbit = new Hobbit("Frodo Baggins", address, stuff);

		System.out.println("Hobbit country: " + hobbit.getAddress().getCountry());
		System.out.println("Hobbit city: " + hobbit.getAddress().getCity());
		System.out.println("Hobbit stuff: " + hobbit.getStuff());

		Address hobbitAddress = hobbit.getAddress();
		hobbitAddress.setCity("Sarumer Tower");
		hobbitAddress.setCountry("Isengard");

		List<String> hobbitStuff = new ArrayList<>();
		hobbitStuff.remove("Ring of Power");
		hobbitStuff.remove("Sword");

		System.out.println("\nImmutabilility cannot be hacked\n");

		System.out.println("Hobbit country: " + hobbit.getAddress().getCountry());
		System.out.println("Hobbit city: " + hobbit.getAddress().getCity());
		System.out.println("Hobbit stuff: " + hobbit.getStuff());
	}

}
