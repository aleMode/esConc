package es9_1;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class MCDimpl extends UnicastRemoteObject implements MCD{
	
	private static final long serialVersionUID = 1L;

	protected MCDimpl() throws RemoteException {
		super();
	}

	public int mcd(int n, int m) {
		int r;
		while(m != 0) {
			r = n % m;
			n=m;
			m=r;
		}
		return n;
	}
	
	public static void main(String[] args) {
		try {
			MCDimpl euclMCD = new MCDimpl();
			Registry registro = LocateRegistry.createRegistry(1099);
			registro.rebind("MCD", euclMCD);
			System.out.println("Server on");
		}catch(Exception e ) { System.err.println("Errore nella creazione del registro: " + e.toString()); e.printStackTrace();}
	}
}
