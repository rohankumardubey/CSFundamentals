package org.redquark.csfundamentals.designpatterns.structural.proxy.protection;

import org.redquark.csfundamentals.designpatterns.structural.proxy.remote.ReportGenerator;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * @Author Anirudh Sharma
 */
public class ReportGeneratorProtectionProxy implements ReportGeneratorProxy {

	private ReportGenerator reportGenerator;
	private Staff staff;

	public ReportGeneratorProtectionProxy(Staff staff) {
		this.staff = staff;
	}

	@Override
	public String generateDailyReport() {

		if (staff.isOwner()) {
			ReportGenerator reportGenerator = null;
			try {
				reportGenerator = (ReportGenerator) Naming.lookup("rmi://127.0.0.1/PizzaCoRemoteGenerator");
				return reportGenerator.generateDailyReport();
			} catch (RemoteException | NotBoundException | MalformedURLException e) {
				e.printStackTrace();
			}
			return "";
		} else {
			return "Not authorized to view report";
		}
	}
}
