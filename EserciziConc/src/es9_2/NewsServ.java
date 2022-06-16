package es9_2;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface NewsServ extends Remote{
	public void setInfo(String i) throws RemoteException;
	public void aggiungiAbbonato(NewsCli n) throws RemoteException;
}
