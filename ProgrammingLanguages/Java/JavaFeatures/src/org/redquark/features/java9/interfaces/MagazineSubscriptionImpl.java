package org.redquark.features.java9.interfaces;

import java.util.Scanner;

/**
 * @author Anirudh Sharma
 *
 */
public class MagazineSubscriptionImpl implements MagazineSubscription {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter subscription code: 1 for Oracle; 2 for Java");
		int subscriptionCode = scanner.nextInt();

		MagazineSubscription magazineSubscription = new MagazineSubscriptionImpl();

		System.out.println("Edition: " + magazineSubscription.getMagazineEdition(subscriptionCode));
		System.out.println("Frequency: " + magazineSubscription.getMagazineFrequency(subscriptionCode));
		System.out.println("Name: " + magazineSubscription.getMagazineName(subscriptionCode));

		scanner.close();
	}
}
