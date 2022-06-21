package es9_2;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class NewsServImpl extends UnicastRemoteObject implements NewsServ{
	
	private static final long serialVersionUID = 1L;
	private String news;
	List<NewsCli> clienti;
	
	protected NewsServImpl() throws RemoteException {
		this.news = "Nulla per ora";
		clienti = new ArrayList<NewsCli>();
	}

	public void notifyClients() {
		for(NewsCli n : clienti) {
			try {
				n.printNews(news);
			}catch(Exception e) {
				System.err.println("Problema nella comunicazione: " + e);
			}
		}
	}
	
	@Override
	public void aggiungiAbbonato(NewsCli n) throws RemoteException {
		clienti.add(n);
	}

	@Override
	public void setInfo(String i) throws RemoteException {
		this.news = i;
		notifyClients();
		
	}
}
