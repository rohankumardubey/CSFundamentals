package org.redquark.csfundamentals.designpatterns.behavioral.mediator;

/**
 * @Author Anirudh Sharma
 */
public interface Colleague {

	/**
	 * @param mediator - mediator to set for the concrete colleague class
	 */
	void setMediator(MachineMediator mediator);
}
