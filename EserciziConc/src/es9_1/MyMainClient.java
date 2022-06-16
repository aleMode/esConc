package es9_1;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MyMainClient {

	public static void main(String[] args) {
		try{
			Registry registro = LocateRegistry.getRegistry();
			MCD stub = (MCD) registro.lookup("MCD");
			
			int x,y;
			x = 18; y=3;
			System.out.println("MCD("+x+","+y+")="+stub.mcd(x,y));
			x=18; y=6;
			System.out.println("MCD("+x+","+y+")="+stub.mcd(x,y));
			x=18; y=7;
			System.out.println("MCD("+x+","+y+")="+stub.mcd(x,y));
			x=18765; y=345435;
			System.out.println("MCD("+x+","+y+")="+stub.mcd(x,y));
		}catch (Exception e) { System.err.println("Errore:" + e); }
		
		
	}

}
