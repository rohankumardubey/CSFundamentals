package org.redquark.csfundamentals.designpatterns.behavioral.observer;

/**
 * This interface is used by the reporters to update the live commentary on the commentary object. It’s an optional
 * interface just to follow the code to interface principle, not related to the Observer pattern. You should apply
 * oops principles along with the design patterns wherever applicable. The interface contains only one method which
 * is used to change the state of the concrete subject object.
 *
 * @Author Anirudh Sharma
 */
public interface Commentary {

	void setDescription(String description);
}
