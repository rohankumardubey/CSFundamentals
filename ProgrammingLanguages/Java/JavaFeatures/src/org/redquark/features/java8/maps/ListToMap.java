package org.redquark.features.java8.maps;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Anirudh Sharma
 *
 */
public class ListToMap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		List<Hosting> hostings = getData();

		// Convert list to map using id and name
		System.out.println(mapWithIdAndName(hostings));

		// Convert list to map using name and websites
		System.out.println(mapWithNameAndWebsite(hostings));
		
		// Add some duplicate keys in the list
		hostings.add(new Hosting(5, "dupilcate.com", 122200));
		
		// Get a map with no duplicate keys
		System.out.println(removeDuplicateKey(hostings));
		
		// Sorted map
		System.out.println(sortMap(hostings));
	}

	private static List<Hosting> getData() {

		List<Hosting> hostings = new LinkedList<>();

		hostings.add(new Hosting(1, "liquidweb.com", 80000));
		hostings.add(new Hosting(2, "linode.com", 90000));
		hostings.add(new Hosting(3, "digitalocean.com", 120000));
		hostings.add(new Hosting(4, "aws.amazon.com", 200000));
		hostings.add(new Hosting(5, "mkyong.com", 1));

		return hostings;
	}

	private static Map<Integer, String> mapWithIdAndName(List<Hosting> hostings) {

		// key --> id; value --> name
		return hostings.stream().collect(Collectors.toMap(Hosting::getId, Hosting::getName));
	}

	private static Map<String, Long> mapWithNameAndWebsite(List<Hosting> hostings) {

		// key --> name, value --> name
		return hostings.stream().collect(Collectors.toMap(Hosting::getName, Hosting::getWebsites));
	}

	private static Map<Integer, String> removeDuplicateKey(List<Hosting> duplicateHostings) {

		// Remove duplicates
		return duplicateHostings.stream()
				.collect(Collectors.toMap(Hosting::getId, Hosting::getName, (oldValue, newValue) -> newValue));
	}

	private static Map<String, Long> sortMap(List<Hosting> hostings) {
		
		return hostings.stream().sorted(Comparator.comparingLong(Hosting::getWebsites)).collect(Collectors
				.toMap(Hosting::getName, Hosting::getWebsites, (oldValue, newValue) -> newValue, LinkedHashMap::new));
	}
	
	private static class Hosting {

		private int id;
		private String name;
		private long websites;

		/**
		 * @param id
		 * @param name
		 * @param websites
		 */
		public Hosting(int id, String name, long websites) {
			super();
			this.id = id;
			this.name = name;
			this.websites = websites;
		}

		/**
		 * @return the id
		 */
		public int getId() {
			return id;
		}

		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}

		/**
		 * @return the websites
		 */
		public long getWebsites() {
			return websites;
		}

		@Override
		public String toString() {
			return "Hosting [id=" + id + ", name=" + name + ", websites=" + websites + "]";
		}
	}
}
