package org.redquark.features.java9.interfaces;

/**
 * @author Anirudh Sharma
 *
 */
public interface MagazineSubscription {

	private String getMagazine(int subscriptionCode) {
		if (subscriptionCode == 1) {
			return "Oracle Magazine";
		} else if (subscriptionCode == 2) {
			return "Java Magazine";
		} else {
			return "Invalid subscription code";
		}
	}

	default String getMagazineFrequency(int subscriptionCode) {
		if (getMagazine(subscriptionCode).equals("Oracle Magazine")) {
			return "Weekly";
		} else if (getMagazine(subscriptionCode).equals("Java Magazine")) {
			return "Monthly";
		} else {
			return "Invalid subscription code";
		}
	}

	default String getMagazineEdition(int subscriptionCode) {
		if (getMagazine(subscriptionCode).equals("Oracle Magazine")) {
			return "Print only";
		} else if (getMagazine(subscriptionCode).equals("Java Magazine")) {
			return "Digital only";
		} else {
			return "Invalid subscription code";
		}
	}

	default String getMagazineName(int subscriptionCode) {
		if (getMagazine(subscriptionCode).equals("Oracle Magazine")) {
			return "Oracle";
		} else if (getMagazine(subscriptionCode).equals("Java Magazine")) {
			return "Java";
		} else {
			return "Invalid subscription code";
		}
	}
}
