package org.redquark.csfundamentals.designpatterns.behavioral.iterator;

/**
 * @Author Anirudh Sharma
 */
public class Shape {

	private int id;
	private String name;

	public Shape(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Id: " + id + ". Name: " + name;
	}
}
