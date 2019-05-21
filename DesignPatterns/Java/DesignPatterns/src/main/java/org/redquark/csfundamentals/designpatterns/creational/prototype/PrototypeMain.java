package org.redquark.csfundamentals.designpatterns.creational.prototype;

/**
 * @Author Anirudh Sharma
 */
public class PrototypeMain {

	public static void main(String[] args) {

		AccessControl userAccessControl = AccessControlProvider.getAccessControlObject("USER");
		User user = new User("UserA", "User Level", userAccessControl);
		System.out.println(user);

		userAccessControl = AccessControlProvider.getAccessControlObject("USER");
		user = new User("UserB", "User Level", userAccessControl);
		System.out.println("Changing access conrol level of " + user.getUserName());
		user.getAccessControl().setAccess("READ REPORTS");
		System.out.println(user);

		AccessControl managerAcessControl = AccessControlProvider.getAccessControlObject("MANAGER");
		user = new User("ManagerA", "Manager Level", managerAcessControl);
		System.out.println(user);
	}
}
