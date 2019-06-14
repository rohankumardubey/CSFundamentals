package org.redquark.csfundamentals.designpatterns.structural.proxy.remote;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * @Author Anirudh Sharma
 */
public class ReportGeneratorClient {

	public static void main(String[] args) {

		try {
			ReportGenerator reportGenerator = (ReportGenerator) Naming.lookup("rmi://127.0.0.1/PizzaCoRemoteGenerator");
			System.out.println(reportGenerator.generateDailyReport());
		} catch (NotBoundException | MalformedURLException | RemoteException e) {
			e.printStackTrace();
		}
	}
}
