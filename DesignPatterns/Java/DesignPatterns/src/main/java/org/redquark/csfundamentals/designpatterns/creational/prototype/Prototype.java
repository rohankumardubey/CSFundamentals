package org.redquark.csfundamentals.designpatterns.creational.prototype;

/**
 * @Author Anirudh Sharma
 */
public interface Prototype extends Cloneable {

	AccessControl clone() throws CloneNotSupportedException;
}
