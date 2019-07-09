package org.redquark.features.java8.maps;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Anirudh Sharma
 *
 */
public class FilterAMap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Getting data
		Map<Integer, String> hostings = getData();

		System.out.println("Before Java 8: " + filterMapBeforeJava8(hostings));
		System.out.println("With Java 8: " + filterMapWithJava8(hostings));

	}

	private static String filterMapBeforeJava8(Map<Integer, String> hostings) {

		String result = "";
		for (Map.Entry<Integer, String> entry : hostings.entrySet()) {
			if ("aws.amazon.com".equals(entry.getValue())) {
				result = entry.getValue();
			}
		}

		return result;
	}

	private static String filterMapWithJava8(Map<Integer, String> hostings) {

		return hostings.entrySet().stream().filter(item -> {
			return (!item.getValue().contains("amazon") && !item.getValue().contains("digital"));
		}).map(map -> map.getValue()).collect(Collectors.joining(", "));
	}

	private static Map<Integer, String> getData() {

		Map<Integer, String> hostings = new HashMap<>();
		hostings.put(1, "linode.com");
		hostings.put(2, "heroku.com");
		hostings.put(3, "digitalocean.com");
		hostings.put(4, "aws.amazon.com");

		return hostings;
	}

}
