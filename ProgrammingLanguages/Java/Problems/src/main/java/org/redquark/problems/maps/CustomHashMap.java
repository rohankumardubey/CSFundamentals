package org.redquark.problems.maps;

/**
 * @author Anirudh Sharma
 *
 */
public class CustomHashMap<K, V> {

	// Array of entry objects
	private Entry<K, V>[] table;

	// Initial capacity of HashMap
	private int capacity = 4;

	/**
	 * Default constructor that will create an Entry array of size capacity
	 */
	@SuppressWarnings("unchecked")
	public CustomHashMap() {
		table = new Entry[capacity];
	}

	/**
	 * This class represents one bucket location
	 *
	 * @param <K>
	 * @param <V>
	 */
	private static class Entry<K, V> {

		// Object to store key of the HashMap
		private Object key;
		// Object to store value of the HashMap
		private Object value;
		// Object to store next pointer of a node at the bucket location
		private Entry<K, V> next;

		/**
		 * Constructor which initialized all the values
		 */
		public Entry(K key, V value, Entry<K, V> next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}

	/**
	 * Method allows you put key-value pair in HashMapCustom. If the map already
	 * contains a mapping for the key, the old value is replaced.
	 * 
	 * 
	 * Note: method does not allows you to put null key though it allows null
	 * values. Implementation allows you to put custom objects as a key as well.
	 * 
	 * 
	 * Key Features: implementation provides you with following features:
	 * 
	 * -> provide complete functionality how to override equals method. -> provide
	 * complete functionality how to override hashCode method.
	 * 
	 * @param newKey
	 * @param data
	 */
	public void put(K key, V value) {

		// Does not allow to store null
		if (key == null) {
			return;
		}

		// Calculate hash of the Key
		int hash = hash(key);

		// Create a new Entry object
		Entry<K, V> entry = new Entry<>(key, value, null);

		// If table location does not contain entry, store entry there
		if (table[hash] == null) {
			table[hash] = entry;
		} else {
			Entry<K, V> previous = null;
			Entry<K, V> current = table[hash];

			// Loop until we reach the last entry of the bucket
			while (current != null) {
				if (current.key.equals(key)) {
					// If this is the case then we have to insert a node at the first location of
					// the bucket
					if (previous == null) {
						entry.next = current.next;
						table[hash] = entry;
						return;
					} else {
						entry.next = current.next;
						previous.next = entry;
						return;
					}
				}

				previous = current;
				current = current.next;
			}

			previous.next = entry;
		}
	}

	/**
	 * This method returns the value stored corresponding to key
	 */
	@SuppressWarnings("unchecked")
	public V get(K key) {
		// Getting the hash value of the Key object
		int hash = hash(key);

		if (table[hash] == null) {
			return null;
		} else {
			Entry<K, V> entry = table[hash];

			// Implementing equals method for the keys
			while (entry != null) {
				if (entry.key.equals(key)) {
					return (V) entry.value;
				}
				entry = entry.next;
			}
		}

		return null;
	}

	/**
	 * This method deletes the given key
	 */
	public boolean remove(K key) {

		// Find the hash of the key to be removed
		int hash = hash(key);

		if (table[hash] == null) {
			return false;
		} else {

			// Previous and current pointers
			Entry<K, V> previous = null;
			Entry<K, V> current = table[hash];

			// Loop until we reach last node of the entry
			while (current != null) {
				if (current.key.equals(key)) {
					table[hash] = table[hash].next;
					return true;
				} else {
					previous.next = current.next;
				}

				previous = current;
				current = current.next;
			}

			return false;
		}
	}

	/**
	 * This method displays all the key value pairs stored in the custom hash map
	 */
	public void display() {
		for (int i = 0; i < capacity; i++) {
			if (table[i] != null) {
				Entry<K, V> entry = table[i];
				while (entry != null) {
					System.out.print("{" + entry.key + " = " + entry.value + "}");
					entry = entry.next;
				}
			}
		}
	}

	/**
	 * This method returns the hash value for the given key
	 */
	private int hash(K key) {
		return Math.abs(key.hashCode()) % capacity;
	}

	public static void main(String[] args) {

		CustomHashMap<Integer, String> customHashMap = new CustomHashMap<>();

		// Adding some values
		customHashMap.put(1, "Superman");
		customHashMap.put(2, "Batman");
		customHashMap.put(3, "Aquaman");
		customHashMap.put(4, "Green Lantern");
		customHashMap.put(5, "Flash");

		System.out.println(customHashMap.get(2));
		System.out.println(customHashMap.get(4));

		System.out.print("Complete Hash Map: ");
		customHashMap.display();
	}

}
