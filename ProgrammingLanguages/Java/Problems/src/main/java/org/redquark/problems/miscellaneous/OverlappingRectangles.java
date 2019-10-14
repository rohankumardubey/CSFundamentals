package org.redquark.problems.miscellaneous;

/**
 * Given two rectangles, find if the given two rectangles overlap or not. 
 * 
 * Note that a rectangle can be represented by two coordinates, top left and bottom
 * right. So mainly we are given following four coordinates - 
 *  
 * l1: Top Left coordinate of first rectangle. 
 * r1: Bottom Right coordinate of first rectangle. 
 * l2: Top Left coordinate of second rectangle. 
 * r2: Bottom Right coordinate of second rectangle.
 * 
 * @author Anirudh Sharma
 *
 */
public class OverlappingRectangles {

	/**
	 * A class representing one point in the 2D plane
	 */
	private static class Point {
		// Abscissa
		int x;
		// Ordinate
		int y;
	}

	/**
	 * This method checks if the two rectangles overlap
	 */
	private static boolean doOverlap(Point l1, Point r1, Point l2, Point r2) {

		// Check if two rectangles overlap horizontally
		if (r2.x < l1.x || r1.x < l2.x) {
			return false;
		}

		// Check if two rectangles overlap vertically
		if (r1.y > l2.y || r2.y > l1.y) {
			return false;
		}

		return true;
	}

	public static void main(String[] args) {

		Point l1 = new Point(), r1 = new Point(), l2 = new Point(), r2 = new Point();
		l1.x = 0;
		l1.y = 10;
		r1.x = 10;
		r1.y = 0;
		l2.x = 5;
		l2.y = 5;
		r2.x = 15;
		r2.y = 0;

		System.out.println(doOverlap(l1, r1, l2, r2) ? "Rectangles overlap" : "Rectangles don't overlap");
	}

}
