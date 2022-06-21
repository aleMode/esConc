package es9_2;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class NewsCliImpl extends UnicastRemoteObject implements NewsCli {
	
	private static final long serialVersionUID = 1L;
	private NewsServ service;
	private String name;
	
	protected NewsCliImpl(NewsServ n, String s) throws RemoteException {
		this.name = s;
		service = n;
		service.aggiungiAbbonato(this);
	}

	@Override
	public void printNews(String s) throws RemoteException {
		System.out.println(this.name + " ha ricevuto: " + s);

	}


}
