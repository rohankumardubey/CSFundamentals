package org.redquark.csfundamentals.designpatterns.structural.proxy.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @Author Anirudh Sharma
 */
public interface ReportGenerator extends Remote {

	String generateDailyReport() throws RemoteException;
}
