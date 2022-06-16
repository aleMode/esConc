package es9_2;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class servMain {
	public static void main(String[] args) throws RemoteException {
		try {
			NewsServImpl a = new NewsServImpl();
			Registry registro = LocateRegistry.createRegistry(9999);
			registro.rebind("news", a);
			System.out.println("Server pronto");
			
			int i = 0;
			while(true) {
				String tmp = "Piero pelù ha i peli + " + i++;
				a.setInfo(tmp);
				System.out.println(tmp);
				Thread.sleep(10000);
			}
		}catch(Exception e) {System.err.println("Errore di setup: " + e);}
	}
}
