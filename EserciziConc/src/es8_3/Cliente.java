package es8_3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.StringTokenizer;

public class Cliente extends Thread{
	private Socket socket;
	private ObjectInputStream in;
	private ObjectOutputStream out;
	
	Cliente(Socket s) throws IOException{
		this.socket = s;
		this.in = new ObjectInputStream (socket.getInputStream());
		this.out = new ObjectOutputStream(socket.getOutputStream());
		start();
	}
	
	public void run(){	
		String local = "";
		BufferedReader locIn = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			try {
				local = locIn.readLine();

				if(local.equals("END") || local.equals("READ") || local.startsWith("OFFER")) {
					out.writeObject(local);
					System.out.println((String) in.readObject());
				}
				
				if(local.equals("END"))
					break;
			} catch (IOException | ClassNotFoundException e) {}
		}
		try {
			socket.close();
		} catch (IOException e) {}
	}
	
}
