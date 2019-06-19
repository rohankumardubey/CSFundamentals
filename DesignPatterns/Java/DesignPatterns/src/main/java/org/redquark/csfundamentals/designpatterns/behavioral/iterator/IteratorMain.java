package org.redquark.csfundamentals.designpatterns.behavioral.iterator;

/**
 * @Author Anirudh Sharma
 */
public class IteratorMain {

	public static void main(String[] args) {

		ShapeStorage storage = new ShapeStorage();
		storage.addShape("Polygon");
		storage.addShape("Hexagon");
		storage.addShape("Circle");
		storage.addShape("Rectangle");
		storage.addShape("Square");

		ShapeIterator shapeIterator = new ShapeIterator(storage.getShapes());

		while (shapeIterator.hasNext()) {
			System.out.println(shapeIterator.next());
		}

		System.out.println("Apply removing while iterating");
		shapeIterator = new ShapeIterator(storage.getShapes());

		while (shapeIterator.hasNext()) {
			System.out.println(shapeIterator.next());
			shapeIterator.remove();
		}
	}
}
