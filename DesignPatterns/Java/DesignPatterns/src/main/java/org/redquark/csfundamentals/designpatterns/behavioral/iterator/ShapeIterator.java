package org.redquark.csfundamentals.designpatterns.behavioral.iterator;

import java.util.Iterator;

/**
 * @Author Anirudh Sharma
 */
public class ShapeIterator implements Iterator<Shape> {

	private int position;
	private Shape[] shapes;

	public ShapeIterator(Shape[] shapes) {
		this.shapes = shapes;
	}

	@Override
	public boolean hasNext() {
		return position < shapes.length && shapes[position] != null;
	}

	@Override
	public Shape next() {
		return shapes[position++];
	}

	@Override
	public void remove() {

		if (position <= 0) {
			throw new IllegalStateException("Invalid position");
		}

		if (shapes[position - 1] != null) {
			if (shapes.length - 1 - position - 1 >= 0)
				System.arraycopy(shapes, position - 1 + 1, shapes, position - 1, shapes.length - 1 - position - 1);
			shapes[shapes.length - 1] = null;
		}
	}
}
