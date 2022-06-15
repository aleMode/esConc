package es7_2;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class ClientHandler {

	public static void main(String[] args) throws IOException, InterruptedException {
		InetAddress addr = InetAddress.getByName(null);
		
			Socket s = new Socket(addr, 9999);
			Cliente a = new Cliente(s);
			a.join();
		
	}

}
