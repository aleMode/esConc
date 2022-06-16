package es9_2;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CliMain {

	public static void main(String[] args) throws RemoteException, NotBoundException {
		Registry registro = LocateRegistry.getRegistry(9999);
		NewsServ news = (NewsServ) registro.lookup("news");
		
		for(int i = 0; i < 5; i++) {
			new NewsCliImpl(news, "Tizio_" + i);
		}
	}

}
