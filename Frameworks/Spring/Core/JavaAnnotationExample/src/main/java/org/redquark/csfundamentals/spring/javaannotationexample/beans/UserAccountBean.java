package org.redquark.csfundamentals.spring.javaannotationexample.beans;

/**
 * @author Anirudh Sharma
 */
public class UserAccountBean {

	private String userName;
	private String password;
	private String email;

	/**
	 * @param userName
	 */
	public UserAccountBean(String userName) {
		super();
		this.userName = userName;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	public String sayHello() {
		return "UserAccountBean [userName=" + userName + ", password=" + password + ", email=" + email + "]";
	}

}
