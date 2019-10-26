package org.redquark.problems.miscellaneous;

/**
 * Suppose there is a circle. There are n petrol pumps on that circle. You are
 * given two sets of data.
 * 
 * 
 * 1. The amount of petrol that every petrol pump has. 2. Distance from that
 * petrol pump to the next petrol pump.
 * 
 * 
 * Calculate the first point from where a truck will be able to complete the
 * circle (The truck will stop at each petrol pump and it has infinite
 * capacity). Expected time complexity is O(n). Assume for 1-litre petrol, the
 * truck can go 1 unit of distance.
 * 
 * For example, let there be 4 petrol pumps with amount of petrol and distance
 * to next petrol pump value pairs as {4, 6}, {6, 5}, {7, 3} and {4, 5}. The
 * first point from where the truck can make a circular tour is 2nd petrol pump.
 * Output should be “start = 1” (index of 2nd petrol pump).
 * 
 * @author Anirudh Sharma
 *
 */
public class TourThatVisitsAllStations {

	/**
	 * This class represents a Petrol pump which has amount of petrol and distance
	 * to the next petrol
	 */
	private static class PetrolPump {

		// Amount of petrol a petrol pump has
		private int petrol;
		// Distance from the next petrol pump
		private int distance;

		/**
		 * Constructor
		 */
		PetrolPump(int petrol, int distance) {
			this.petrol = petrol;
			this.distance = distance;
		}
	}

	/**
	 * This method returns starting point if a solution is possible otherwise
	 * returns -1
	 */
	private static int printTour(PetrolPump[] arr, int n) {

		int start = 0;
		int end = 1;
		int currentPetrol = arr[start].petrol - arr[start].distance;

		// Run a loop while all petrol pumps are not visited.
		// And we have reached first petrol pump again with 0 or more petrol
		while (end != start || currentPetrol < 0) {
			// If current amount of petrol in truck becomes less than 0, then remove the
			// starting petrol pump from tour
			while (currentPetrol < 0 && start != end) {
				// Remove starting petrol pump. Change start
				currentPetrol -= arr[start].petrol - arr[start].distance;
				start = (start + 1) % n;

				// If 0 is being considered as start again, then there is no possible solution
				if (start == 0) {
					return -1;
				}
			}

			// Add a petrol pump to current tour
			currentPetrol += arr[end].petrol - arr[end].distance;
			end = (end + 1) % n;
		}

		// Return starting point
		return start;
	}

	public static void main(String[] args) {

		PetrolPump[] arr = { new PetrolPump(6, 4), new PetrolPump(3, 6), new PetrolPump(7, 3) };
		int start = printTour(arr, arr.length);
		System.out.println(start == -1 ? "No Solution" : "Start = " + start);
	}

}
