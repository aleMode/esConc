package es7_2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class CasaAsta {
	public static final int PORT = 9999;
	private static int WAITOFFER = 100000;
	
	public static void main(String[] args) throws IOException {
		Asta asta = new Asta("Quadro", 50, 5);
		ServerSocket s = new ServerSocket(PORT);
		System.out.println("Server online per asta per: " + asta.nomeOggetto);
		
		s.setSoTimeout(1000);
		
		while(true) {
			Socket client;
			
			try{
				client = s.accept();
				new AstaServ(asta, client);
			}catch(SocketTimeoutException e){
				if(System.currentTimeMillis() - asta.timeOffer() >= WAITOFFER) {
					System.out.println("Asta conclusa, oggetto: " + asta.nomeOggetto + " aggiudicato da: " + asta.retName());
					break;
				}		
			}
		}
		System.out.println("Fine");
		s.close();
	}
}
