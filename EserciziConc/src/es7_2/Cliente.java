package es7_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.StringTokenizer;

public class Cliente extends Thread{
	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	
	Cliente(Socket s) throws IOException{
		this.socket = s;
		this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		this.out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);
		start();
	}
	
	public void run(){	
		String local = "";
		BufferedReader locIn = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			try {
				local = locIn.readLine();

				if(local.equals("END") || local.equals("READ") || local.startsWith("OFFER")) {
					out.println(local);
					System.out.println(in.readLine());
				}
				
				if(local.equals("END"))
					break;
			} catch (IOException e) {}
		}
		try {
			socket.close();
		} catch (IOException e) {}
	}
	
}
