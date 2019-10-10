package org.redquark.problems.miscellaneous;

/**
 * @author Anirudh Sharma
 *
 */
public class OverlappingTriangles {

	private static class Point {
		// Abscissa
		int x;
		// Ordinate
		int y;
	}

	private static boolean doOverlap(Point l1, Point r1, Point l2, Point r2) {

		if (r2.x < l1.x || r1.x < l2.x) {
			return false;
		}

		if (r1.y > l2.y || r2.y > l1.y ) {
			return false;
		}

		return true;
	}

	public static void main(String[] args) {

		Point l1 = new Point(), r1 = new Point(), l2 = new Point(), r2 = new Point();
		l1.x = 1;
		l1.y = 5;
		r1.x = 3;
		r1.y = 4;
		l2.x = 1;
		l2.y = 3;
		r2.x = 3;
		r2.y = 3;

		if (doOverlap(l1, r1, l2, r2)) {
			System.out.println("Rectangles Overlap");
		} else {
			System.out.println("Rectangles Don't Overlap");
		}
	}

}
