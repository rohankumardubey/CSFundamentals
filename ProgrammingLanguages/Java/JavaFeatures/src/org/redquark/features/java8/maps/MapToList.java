package org.redquark.features.java8.maps;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Anirudh Sharma
 *
 */
public class MapToList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Map<Integer, String> data = null;
		data = addDataToMap(data);

		System.out.println("Before Java 8...");
		mapToListBeforeJava8(data);

		System.out.println("\nJava 8...");
		mapToListJava8(data);

		System.out.println("\nConvert map into two lists");
		convertMapIntoTwoLists(data);
	}

	private static Map<Integer, String> addDataToMap(Map<Integer, String> data) {

		data = new HashMap<>();

		data.put(10, "apple");
		data.put(20, "orange");
		data.put(30, "banana");
		data.put(40, "watermelon");
		data.put(50, "dragonfruit");

		return data;
	}

	private static void mapToListBeforeJava8(Map<Integer, String> data) {

		System.out.println("\nExport map keys to list...");
		List<Integer> keyList = new LinkedList<>(data.keySet());
		keyList.forEach(System.out::println);

		System.out.println("\nExport map values to list...");
		List<String> valueList = new LinkedList<>(data.values());
		valueList.forEach(System.out::println);
	}

	private static void mapToListJava8(Map<Integer, String> data) {

		System.out.println("\n1. Export map keys to list");
		List<Integer> keyList = data.keySet().stream().collect(Collectors.toList());
		keyList.forEach(System.out::println);

		System.out.println("\n2. Export map values to list");
		List<String> valueList = data.values().stream().collect(Collectors.toList());
		valueList.forEach(System.out::println);

		System.out.println("\n3. Export map values to list... Say no to banana");
		List<String> noBananaList = data.values().stream().filter(item -> !"banana".equalsIgnoreCase(item))
				.collect(Collectors.toList());
		noBananaList.forEach(System.out::println);
	}

	private static void convertMapIntoTwoLists(Map<Integer, String> data) {

		// Split a map into two lists
		List<Integer> keyList = new LinkedList<>();
		List<String> valueList = data.entrySet().stream().sorted(Map.Entry.<Integer, String>comparingByKey().reversed())
				.peek(item -> keyList.add(item.getKey())).map(item -> item.getValue())
				.filter(item -> !"banana".equalsIgnoreCase(item)).collect(Collectors.toList());

		keyList.forEach(System.out::println);
		valueList.forEach(System.out::println);
	}
}
