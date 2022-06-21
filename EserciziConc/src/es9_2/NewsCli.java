package es9_2;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface NewsCli extends Remote{
	public void printNews(String i) throws RemoteException;
}
