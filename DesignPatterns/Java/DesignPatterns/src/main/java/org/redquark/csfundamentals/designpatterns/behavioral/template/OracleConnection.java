package org.redquark.csfundamentals.designpatterns.behavioral.template;

/**
 * @Author Anirudh Sharma
 */
public class OracleConnection extends DBConnectionTemplate {


	@Override
	public void setDBDriver() {
		System.out.println("Setting Oracle DB drivers...");
	}

	@Override
	public void setCredentials() {
		System.out.println("Setting credentials for Oracle DB...");
	}

	@Override
	public void setData() {
		System.out.println("Setting up data from text file...");
	}
}
