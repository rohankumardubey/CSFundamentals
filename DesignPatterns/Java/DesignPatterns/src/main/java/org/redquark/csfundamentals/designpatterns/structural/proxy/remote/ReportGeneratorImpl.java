package org.redquark.csfundamentals.designpatterns.structural.proxy.remote;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

/**
 * @Author Anirudh Sharma
 */
public class ReportGeneratorImpl extends UnicastRemoteObject implements ReportGenerator {

	protected ReportGeneratorImpl() throws RemoteException {

	}

	public static void main(String[] args) {
		ReportGenerator reportGenerator = null;
		try {
			reportGenerator = new ReportGeneratorImpl();
			Naming.rebind("PizzaCoRemoteGenerator", reportGenerator);
		} catch (RemoteException | MalformedURLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public String generateDailyReport() throws RemoteException {
		StringBuilder sb = new StringBuilder();
		sb.append("********************Location X Daily Report********************");
		sb.append("\\n Location ID: 012");
		sb.append("\\n Today’s Date: ").append(new Date());
		sb.append("\\n Total Pizza’s Sell: 112");
		sb.append("\\n Total Price: $2534");
		sb.append("\\n Net Profit: $1985");
		sb.append("\\n***************************************************************");
		return sb.toString();
	}
}
