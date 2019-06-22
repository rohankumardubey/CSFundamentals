package org.redquark.features.java8.streams;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Anirudh Sharma
 *
 */
public class ObjectConversion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Declaring and initializing list
		List<Staff> staffMembers = new LinkedList<>();

		// Add some data to the list
		addData(staffMembers);

		// Convert one object to other conventional way
		System.out.println("Conventional Way: " + convertStaffToStaffPublicConventionalWay(staffMembers));

		// Convert object to other the Java 8 way
		System.out.println("Java 8 Way: " + convertStaffToStaffPublicJava8Way(staffMembers));

	}

	/**
	 * This method adds some data into the list to initialize it
	 * 
	 * @param staffMembers
	 * @return {@link List}
	 */
	private static List<Staff> addData(List<Staff> staffMembers) {

		// Adding data using Staff object's constructor
		staffMembers.add(new Staff("Clark Kent", 32, 100000.0));
		staffMembers.add(new Staff("Bruce Wayne", 31, 150000.0));
		staffMembers.add(new Staff("Diana Prince", 29, 240000.0));
		staffMembers.add(new Staff("Arthur Curry", 33, 90000.0));
		staffMembers.add(new Staff("Barthelomew Allen", 27, 110000.0));

		return staffMembers;

	}

	/**
	 * This method converts one object to other the conventional way
	 * 
	 * @param staffMemebers
	 * @return {@link List}
	 */
	private static List<StaffPublic> convertStaffToStaffPublicConventionalWay(List<Staff> staffMembers) {

		List<StaffPublic> publicStaffMembers = new LinkedList<>();

		// Loop for each element in the list
		for (Staff member : staffMembers) {

			StaffPublic staffPublic = new StaffPublic();

			staffPublic.setName(member.getName());
			staffPublic.setAge(member.getAge());

			if (member.getName().equals("Diana Prince")) {
				staffPublic.setExtra("She is the Queen of Amazons");
			}

			// Adding object to the list
			publicStaffMembers.add(staffPublic);
		}

		return publicStaffMembers;
	}

	private static List<StaffPublic> convertStaffToStaffPublicJava8Way(List<Staff> staffMembers) {

		List<StaffPublic> publicStaffMembers = staffMembers.stream().map(member -> {
			StaffPublic staffPublic = new StaffPublic();

			staffPublic.setName(member.getName());
			staffPublic.setAge(member.getAge());

			if (member.getName().equals("Diana Prince")) {
				staffPublic.setExtra("She is the Queen of Amazons");
			}
			return staffPublic;
		}).collect(Collectors.toList());

		return publicStaffMembers;
	}

	private static class Staff {

		private String name;
		private int age;
		private double salary;

		/**
		 * @param name
		 * @param age
		 * @param salary
		 */
		public Staff(String name, int age, double salary) {
			super();
			this.name = name;
			this.age = age;
			this.salary = salary;
		}

		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}

		/**
		 * @return the age
		 */
		public int getAge() {
			return age;
		}

		@Override
		public String toString() {
			return "Staff [name=" + name + ", age=" + age + ", salary=" + salary + "]";
		}
	}

	private static class StaffPublic {

		private String name;
		private int age;
		private String extra;

		/**
		 * @param name the name to set
		 */
		public void setName(String name) {
			this.name = name;
		}

		/**
		 * @param age the age to set
		 */
		public void setAge(int age) {
			this.age = age;
		}

		/**
		 * @param extra the extra to set
		 */
		public void setExtra(String extra) {
			this.extra = extra;
		}

		@Override
		public String toString() {
			return "StaffPublic [name=" + name + ", age=" + age + ", extra=" + extra + "]";
		}
	}
}
